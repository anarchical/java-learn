import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.ContextConfig;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * @author YeYaqiao
 */
public class TomcatServer {
    public static void main(String[] args) throws LifecycleException, IOException {


        String workspace = System.getProperty("user.dir");

        String webapp = new File(workspace,"31-springMVC/src/main/webapp").getPath();

        Tomcat tomcat = new Tomcat();

        // 看源码发现,他只能设置一个service,直接拿默认的
        Service service = tomcat.getService();

        // 创建连接器,并且添加对应的连接器,同时连接器指定端口
        Connector connector = new Connector();
        connector.setPort(8888);
        service.addConnector(connector);

        // 创建一个引擎,放入service中
        Engine engine = new StandardEngine();
        service.setContainer(engine);
        engine.setDefaultHost("localhost");
        engine.setName("myTomcat");

        // 添加host
        Host host = new StandardHost();
        engine.addChild(host);
        host.setName("localhost");

        // 在对应的host下面创建一个 context 并制定他的工作路径,会加载该目录下的所有class文件,或者静态文件
        tomcat.getHost().setAppBase("webapp");
        StandardContext context = (StandardContext) tomcat.addContext(host, "", webapp);

        // 初始化ContextConfig配置
        context.addLifecycleListener(new ContextConfig());

        //tomcat启动
        tomcat.start();
        //保持主线程不退出
        tomcat.getServer().await();

    }


}
