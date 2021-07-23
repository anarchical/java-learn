package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @author YeYaqiao
 */
@WebServlet("/test")
public class MyServlet extends HttpServlet {

    public MyServlet() {
        System.out.println("constructor");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");

        //ServletConfig 属于某个特定的 servlet
        System.out.println(servletConfig.getServletName());

        //ServletContext 全局对象，一个 Web 应用只能有一个 ServletContext
        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println(servletContext.getRealPath("/"));
        System.out.println(servletContext.getServerInfo());
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("test");
        res.getWriter().write("success");
    }
}
