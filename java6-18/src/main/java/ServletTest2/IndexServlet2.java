package ServletTest2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test")
public class IndexServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw=resp.getWriter();
        String i=req.getParameter("i");
        HttpSession session = req.getSession(false);
        if(session==null){
            resp.setStatus(401);
            pw.println("没有登录");
            pw.flush();
            return ;
        }
        String name= (String) session.getAttribute("user");
        String a=req.getParameter("i");
        if("1".equals(a)){
            resp.sendRedirect("index.html");
        }else if("2".equals(a)){
            req.getRequestDispatcher("index.html").forward(req,resp);
        }else{
            try {
                Integer.parseInt(a);
                pw.println("是个整数:"+a);
            } catch (NumberFormatException e) {
                resp.setStatus(400);
                pw.println("非数字:"+a);
            }
        }

    }
}
