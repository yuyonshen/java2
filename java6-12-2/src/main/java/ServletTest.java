import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test")
public class ServletTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String username=req.getParameter("username");
        String password=req.getParameter("password");
        PrintWriter pw=resp.getWriter();
        if("abc".equals(username)&&"123".equals(password)){
            pw.println("登录成功");
        }else{
            pw.println("登录失败");
        }
        pw.flush();
    }
}
