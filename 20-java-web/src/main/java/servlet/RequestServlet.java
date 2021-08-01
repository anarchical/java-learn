package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author YeYaqiao
 */
@WebServlet("/request")
public class RequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = "Hello World! 你好，世界！";
        //将键值对信息通过 HttpServletRequest 存入 servlet
        req.setAttribute("result", result);
        //页面重定向到 request.jsp
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("request.jsp");
        requestDispatcher.forward(req, resp);

        //获取 url 地址栏上的参数信息，Http请求传输时将 url 以ISO-8859-1编码，中文会导致乱码
        String method = new String(req.getParameter("method").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        System.out.println(method);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取 url 地址栏上的参数信息，不对ISO-8859-1进行转码会导致中文乱码
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        System.out.println(method);
        //向客户端返回信息
        resp.getWriter().write("doPost response");
        resp.sendRedirect("redirect.jsp");
    }
}
