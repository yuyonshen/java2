import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw=resp.getWriter();
        HttpSession session = req.getSession(false);
        if(session==null){
            resp.setStatus(401);
            pw.println("没有登陆,不允许访问");
            pw.flush();
            return ;
        }
        String username=(String)session.getAttribute("user");



        String i=req.getParameter("i");
        if("1".equals(i)){//演示重定向
            resp.sendRedirect("index.html");
        }else if("2".equals(i)){//重发
            req.getRequestDispatcher("index.html").forward(req,resp);
        }else{
            try {
                Integer.parseInt(i);
                pw.println("正确的数值+"+i);
            } catch (NumberFormatException e) {
                resp.setStatus(400);
                pw.println("非数字+"+i);
            }
        }
    }
}

