###  SpringMVC

Model View Controller

* Model 模型层：指工程中的  JavaBean，用于处理数据的类（注意和实体类 Bean 区分，用于存储数据和数据表映射的类）
* View 视图层：指工程中的前端页面，如 HTML 或 JSP 等，用于和用户交互数据以及展示数据等
* Controller 控制层：指工程中的 Servlet，用于接收请求数据和响应浏览器数据

用户通过 View 视图层发送数据到服务器；数据在服务器中被 Controller 控制层接收，Controller 层调用相应的 Model 模型层对数据进行处理并返回给 Controller 层；Controller 层再将结果返回给相应的 View 层

#### 核心组件

| 组件名称              | 作用                                     |
| --------------------- | ---------------------------------------- |
| DispatcherServlet     | 前端控制器：作为请求的入口               |
| HandlerMapping        | 处理器映射器：负责将请求和控制器映射起来 |
| Handler（Controller） | 处理器：完成具体的业务逻辑               |
| HandlerAdapter        | 适配器：按照特定的规则去控制执行 Handler |
| ViewResolver          | 视图解析器：定位页面                     |
| ModelAndView          | 视图信息和数据模型信息                   |

1. 用户通过浏览器向服务器发送 request 请求，request 被 SpringMVC 中的 DispatcherServlet 获取；
2. DispatcherServlet 根据 request 中相应的 URI 调用 HandlerMapping 处理器映射器，将请求进一步发送给相应的 Handler（Controller）
3. Handler 执行相应的业务逻辑，将相关的数据信息封装进 ModelAndView，最后通过 ViewResolver 视图解析器选择合适的 View 渲染视图并返回界面

#### 底层原理

Spring Web MVC 是 Spring 框架用来提供 Web 服务的组件，基于 Servlet 开发

* Servlet 的局限性

  每个 Servlet 只能有一个 GET 和 一个 POST 方法，不利于业务逻辑的隔离

* SpringMVC 的解决方法

  SpringMVC 只负责请求的分发，不负责具体的业务逻辑；

  将请求分发给对应的 Handler，不需要实现任何的接口，没有约束

#### 数据校验

数据校验主要有两种形式

* 实现 Validator 接口
* 使用 Annotation JSR-303 标准，使用注解

##### 实现 Validator 接口



##### 基于注解
