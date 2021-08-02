package cookie_login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author YeYaqiao
 */
@WebServlet("/cookieLogin")
public class LoginServlet extends HttpServlet {

    private static final String username = "username";
    private static final String password = "password";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取表单的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals(LoginServlet.username) && password.equals(LoginServlet.password)) {

            Cookie cookie=new Cookie("username",username);
            cookie.setMaxAge(600);
            resp.addCookie(cookie);
            resp.sendRedirect("cookie-login/index.jsp");
        }
    }
}
