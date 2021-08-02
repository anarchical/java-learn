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
@WebServlet("/sessionLogin")
public class LoginServlet extends HttpServlet {

    private static final String username = "username";
    private static final String password = "password";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取表单的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals(LoginServlet.username) && password.equals(LoginServlet.password)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect("session-login/index.jsp");
        }
    }
}
