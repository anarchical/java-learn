import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

/**
 * @author YeYaqiao
 * 通过 main 线程启动内嵌 tomcat
 */
public class TomcatServer {
    public static void main(String[] args) throws LifecycleException {
        // 启动Tomcat:
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8888);
        tomcat.setBaseDir(new File("31-springMVC/target").getAbsolutePath());
        tomcat.getConnector();
        // 创建webapp:
        Context ctx = tomcat.addWebapp(
                "/context",
                new File("31-springMVC/src/main/webapp").getAbsolutePath());
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(
                new DirResourceSet(
                        resources,
                        "/WEB-INF/classes",
                        new File("31-springMVC/target/classes").getAbsolutePath(),
                        "/"));
        ctx.setResources(resources);
        tomcat.start();
        tomcat.getServer().await();
    }

}
