package cookie_login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author YeYaqiao
 */
@WebServlet("/cookieLogout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //销毁 cookie
        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            if (cookie != null) {
                //设置 cookie 失效
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }

        //重定向到登录页面
        resp.sendRedirect("cookie-login/login.jsp");
    }
}
