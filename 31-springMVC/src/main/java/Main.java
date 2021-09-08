import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

/**
 * @author YeYaqiao
 */
public class Main {
    public static void main(String[] args) throws Exception {

        Tomcat tomcat=new Tomcat();
        tomcat.setPort(8888);
        tomcat.getConnector();
        // 创建 WebApp
        Context context = tomcat.addWebapp("", new File("31-springMVC/src/main/webapp").getAbsolutePath());
        WebResourceRoot resources = new StandardRoot(context);
        resources.addPreResources(
                new DirResourceSet(resources, "/WEB-INF/classes",
                        new File("31-springMVC/target/classes").getAbsolutePath(), "/"));
        context.setResources(resources);

        tomcat.start();
        tomcat.getServer().await();
    }
}
