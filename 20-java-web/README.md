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

Java Server Page，通过 Java 程序动态生成的 HTML 页面

通过





#### 常见问题
