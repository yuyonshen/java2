package ServletTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login1")
public class LoginTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw=resp.getWriter();
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        if("abc".equals(username)&&"123".equals(password)){
            pw.println("登录成功");
        }else{
            pw.println("登录失败");
        }
    }
}
