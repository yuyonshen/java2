package yuzhenghan.util.servlet;

import yuzhenghan.util.JSONUtil;
import yuzhenghan.util.dao.ArticleDAO;
import yuzhenghan.util.model.Article;
import yuzhenghan.util.model.Response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

public abstract class   AbstractBaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");


        Response response=new Response();
        try {
//            String id=req.getParameter("id");
//            List<Article> articles= ArticleDAO.query(Integer.parseInt(id));
            response.setSuccess(true);
            response.setData(process(req,resp));
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            StringWriter sw=new StringWriter();
            PrintWriter writer=new PrintWriter(sw);
            e.printStackTrace(writer);
            response.setStackTrace(sw.toString());

        }
        PrintWriter pw=resp.getWriter();
        pw.println(JSONUtil.serialize(response));
        pw.println();
    }

    public abstract Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception ;


}
