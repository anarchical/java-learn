package session_login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author YeYaqiao
 */
@WebServlet("/sessionLogout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //销毁 session
        HttpSession session = req.getSession();
        session.invalidate();
        //重定向到登录页面
        resp.sendRedirect("session-login/login.jsp");
    }
}
