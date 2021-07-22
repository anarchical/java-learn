### JavaWeb

#### Tomcat

Tomcat 是一种 Web 应用服务器

目录结果：

* bin：停启脚本等
* conf：配置文件
* lib：依赖的 jar 包
* logs：相关日志
* temp：运行时的临时文件
* webapps： 允许客户端访问的资源
* work：运行服务所需的资源（Servlet，JSP）

#### Servlet

用 Java 编写的服务端程序，主要用于交互式地浏览和生成数据，生成动态的 Web 内容

Servlet 是用 Java 语言实现的接口，只有实现了 Servlet 接口的类，才能够运行在 Tomcat 服务器中

Servlet 采用单例模式，Tomcat 通过反射机制来创建 Servelt 对象

##### 生命周期

1. 初始化阶段：调用 init() 方法，完成初始化操作（若 Servlet 不存在，则通过 init() 创建；若存在，则直接调用）
2. 响应客户端阶段：调用 service() 方法，执行相关的业务逻辑
3. 终止阶段：调用 destroy() 方法，销毁 Servlet 对象

