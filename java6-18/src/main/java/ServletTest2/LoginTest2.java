package ServletTest2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginTest2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw=resp.getWriter();
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        if("abc".equals(username)&&"123".equals(password)){
            //如果登录密码和用户是正确的我们将这个信息保存在session中
            HttpSession session = req.getSession();
            session.setAttribute("user",username);
            resp.sendRedirect("index.html");
        }else{
            pw.println("登录失败");
        }
    }
}
