package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author YeYaqiao
 */
@WebServlet("/httpServlet")
public class MyHttpServlet extends HttpServlet {

    public MyHttpServlet() {
        System.out.println("constructor");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init httpServlet");

        //ServletConfig 属于某个特定的 servlet
        System.out.println(servletConfig.getServletName());

        //ServletContext 全局对象，一个 Web 应用只能有一个 ServletContext
        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println(servletContext.getRealPath("/"));
        System.out.println(servletContext.getServerInfo());
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req,res);
        System.out.println("httpServlet service");
        res.getWriter().write("httpServlet success");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
    }
}
