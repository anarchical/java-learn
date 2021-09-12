### JavaWeb

#### Tomcat

> Tomcat 与 Servlet 需要版本适配
>
> [版本适配表](https://tomcat.apache.org/whichversion.html)

Tomcat 是一种 Web 应用服务器

目录结构：

* bin：停启脚本等
* conf：配置文件
* lib：依赖的 jar 包
* logs：相关日志
* temp：运行时的临时文件
* webapps： 允许客户端访问的资源
* work：运行服务所需的资源（Servlet，JSP）

#### Servlet

用 Java 编写的服务端程序，只能运行在 Web 服务器中；作为 Web 浏览器或 HTTP 客户端和其它 HTTP 服务端之间的中间层， 主要用于交互式地浏览和生成数据，生成动态的 Web 内容

Servlet 是用 Java 语言实现的接口，只有实现了 Servlet 接口的类，才能够运行在 Tomcat 服务器中

Servlet 采用单例模式，Tomcat 通过反射机制来创建 Servelt 对象

注：实现 Servlet 接口需要同时实现5个方法：init()、getServletConfig()、service()、getServletInfo()、destroy()；过于繁琐，实际开发中只需要继承 HttpServlet 类，重新 doGet()、doPost() 等方法简化代码

##### 生命周期

1. 初始化阶段：调用 init() 方法，完成初始化操作；整个 servlet 生命周期中只会被调用一次（若 Servlet 不存在，则通过 init() 创建；若存在，则直接调用）
2. 响应客户端阶段：调用 service() 方法，执行相关的业务逻辑；servlet 每被调用一次，service() 方法就会执行一次；不同的用户调用都会产生新的线程
3. 终止阶段：调用 destroy() 方法，销毁 Servlet 对象；在 Tomcat 服务器被关闭的时候执行

##### ServletConfig & ServletContext

* ServletConfig

  属于某个 Servlet 类，每个 Servlet 都有自己的 ServletConfig

* ServletContext

  属于整个 Web 应用，一个 Web 服务中只有一个 ServletContext

##### 常用方法

| 方法名                                                   | 作用 |
| -------------------------------------------------------- | ---- |
| doGet(HttpServletRequest req, HttpServletResponse resp)  |      |
| doPost(HttpServletRequest req, HttpServletResponse resp) |      |
|                                                          |      |
|                                                          |      |
|                                                          |      |

#### JSP

Java Server Page，通过 Java 程序动态生成的 HTML 页面 `ServletResponse.getWriter().write()`

客户端通过浏览器调用服务端的 Servlet，Servlet 一行一行地读取 JSP 页面中的内容，通过 `ServletResponse.getWriter().write()` 方法将页面内容输出给客户端

根据 JSP 生成的 Servlet 程序名称通常为`页面名_jsp.java`，并同时生成相应的字节码文件`页面名_jsp.class`

##### 九个内置对象

jsp 内置对象，在 jsp 页面中可以直接使用，无需手动创建

| 对象名      | 作用                                                         |
| ----------- | ------------------------------------------------------------ |
| request     | HttpServletRequest 的一个对象，用于接收客户端的请求          |
| response    | HttpServletResponse 的一个对象，用于回复客户端的请求         |
| pageContext | PageContext 的一个对象，页面上下文，用于获取页面信息         |
| session     | HttpSession 的一个对象，代表浏览器和服务器间的一次会话，用于保存客户端用户的信息 |
| application | ServletContext 的一个对象，代表当前 Web 应用，全局对象，保存着所有客户端用户的共享数据 |
| config      | 当前 JSP 对应的 Servlet 的 ServletConfig 对象，用于获取当前 Servlet 的信息 |
| out         | JspWriter 的一个对象，用于向客户端输出信息，相当于 Servlet 的输出流 |
| page        | 当前 JSP 对应的 Servlet 对象                                 |
| exception   | 表示当前 JSP 页面发生的异常                                  |

##### 四个常用对象及其方法

| 对象名      | 常用方法                                                     |
| ----------- | ------------------------------------------------------------ |
| request     | 1. `String getParameters(String name)` 用于获取前端通过 url 传来的参数<br />2. `void setAttribute(String name, Object value)` 通过键值对的形式保存数据<br />3. `Object getAttribute(String name)` 通过键名获取数据<br />4. `String[] getParameterValues(String name)` 获取前端传来的多个参数<br />5. `void setCharacterEncoding(String charset)` 设置请求的编码<br />6. `RequsetDispatcher getRequestDispatcher(String path)` 返回一个 RequestDispatcher 对象，该对象的 forward() 方法用来完成转发 |
| response    | 1. `void setCharacterEncoding(String charset)` 设置请求的编码<br />2. `void sendRedirect(String path)` 页面重定向<br />3. `void getWriter().writer(String s)` 向客户端返回页面信息 |
| session     |                                                              |
| application |                                                              |

##### 转发 & 重定向

转发（RequsetDispatcher.forward）和重定向（sendRedirect）都是用来完成对资源的转发，从某个资源跳转到另一个资源（Servlet、JSP）

区别：

* 转发（forwoard）

  转发是同一个请求（服务端跳转）

  服务器将客户端的请求指向另外一个资源，跳转过程由服务器完成；对于客户端而言还是同一个请求；地址栏信息不会发生变化

* 重定向（redirect）

  重定向是两个不同的请求（客户端跳转）

  相当于服务器拒绝了当前的客户端请求，并让客户端发起一个新的请求去访问另一个资源；地址栏信息会发生改变

对于增删改类的操作，应使用重定向，防止重复提交请求；对于查询类操作则可以使用转发

注意：如果使用了 request 进行参数传递，必须在转发的情况下才能获取数据；如果是重定向的话，request 并不是客户端原本请求的内容，可能会发生错误；转发是对同一个 Servlet 对象进行访问，重定向是访问了两个不同的对象

#### Session & Cookie

服务器无法识别出 HTTP 请求的来源，就需要一种技术来区别来自不同的客户端请求，这种机制就是会话

会话：打开浏览器客户端并与服务器之间发生的一系列的请求与响应、直到关闭浏览器客户端的全过程

实现会话的技术：

* session 服务器技术，存储于服务器
* cookie 客户端技术，存储于浏览器客户端

##### Session

session 是 jsp 提供的内置对象之一，可以在 jsp 页面中直接使用

session 表示浏览器客户端与服务器产生的一次会话，只要浏览器不关闭，其中所有的页面使用的都是服务器提供的同一个 session

| 常用方法名                                  | 作用                                                         |
| ------------------------------------------- | ------------------------------------------------------------ |
| String gitId()                              | 获取 session 的 id，服务器通过 session id 来区别不同的客户端 |
| void setMaxInactiveInterval(int interval)   | 设置 session 的失效时间，单位为秒                            |
| int getMaxInactiveInterval()                | 获取 session 的有效时间，默认时间为 30 分钟                  |
| void invalidate()                           | 设置 session 失效                                            |
| void setAttribute(String key, Object value) | 向 session 中通过键值对的形式存储数据                        |
| Object getAttribute(String key)             | 通过 key 取出数据                                            |
| void removeAttribute(String key)            | 通过 key 删除对应的 value                                    |

##### Cookie

Cookie 是一个文本类型的文件，存储于浏览器客户端中

当服务器响应浏览器客户端的请求时，会同时传给浏览器客户端一个文本文件，就是 cookie；浏览器保存这个 cookie 并使用其中的数据，并且在每次请求服务器时，都会把 cookie 传回给服务器

cookie 就是这样不断的在服务器和浏览器之间传递，达到数据传递的效果

| 常用方法名                  | 作用                         |
| --------------------------- | ---------------------------- |
| void setMaxAge(int age)     | 设置 cookie 有效期，单位为秒 |
| int getMaxAge()             | 获取 cookie 有效期           |
| void setValue(String value) | 对 cookie 进行赋值           |
| String getName()            | 获取 cookie 的name           |
| String getValue             | 获取 cookie 的 value         |
| request.getCookies()        | 获取 cookie 列表             |

##### 区别

* 存储位置：session 存在服务器中；cookie 存在浏览器客户端中
* 存储类型：session 可以存储任意类型的数据；cookie 只能存储文本类型数据
* 销毁机制：session 随着会话的结束而被销毁，cookie 可以长期保存在客户端
* 应用方式：session 安全性较高，用于存储重要的信息；cookie 用于存储不重要的信息

#### 过滤器

服务器用于拦截请求或响应，用于于登录判断或权限校验，校验通过以后再发送目标资源

```java
@WebFilter("/session-login/index.jsp")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        //判断是否登录
        if (username == null) {
            //重定向
            response.sendRedirect("session-login/login.jsp");
        } else {
            //放行
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
```

#### EL 表达式

Expression Language 表达式语言

可以替代 JSP 页面中数据访问的复杂编码，简化代码

语法：${目标数据的 key}

注：若 EL 表达式不生效，则需要声明开启使用 `<%@ page isELIgnored="false"%>`

#### 常见问题

1. 新建的 JavaWeb 工程为什么默认可以访问 index.jsp 页面？

   Tomcat 启动时，会先去读取 Tomcat 自带的 web.xml，其次再读取项目中的 web.xml；其中 Tomcat 中的 web.xml 的 `<welcome-file-list>` 中定义了访问 context 时默认展示的首页 index.jsp；我们可以在项目中的 web.xml 重写此标签改变访问 context 时的首页页面

