package yuzhenghan;

import javax.servlet.ServletException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 通过http请求路径 /login路径映射到本Servlet，通过@WebServlet中配置的路径关联
 * @WebServlet必须以/开头
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//请求数据编码：请求体产生作用，url中的数据无效
        resp.setCharacterEncoding("UTF-8");//服务端响应的内容设置编码
        //告诉浏览器：1.数据类型（浏览器处理数据的方式）2.编码（浏览器解析数据的编码）
        resp.setContentType("text/html; charset=UTF-8");

        //getParameter获取url中或者请求体中的数据，根据key获取value，获取不到为null
        //接收的请求数据类型，可以是application/x-www-form-urlencoded
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PrintWriter pw = resp.getWriter();
        if ("abc".equals(username) && "123".equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user",username);
            resp.sendRedirect("index.html");
            //获取当前http请求的Session,如果获取不到 :参数为true时:创建一个,如果为false,返回null
            //正泰看,服务器保存session的数据结构为map<v,map<k,v>>
            //HttpSession session1=req.getSession(false);
        } else {
            pw.println("登录失败");
        }
        pw.flush();
    }
}