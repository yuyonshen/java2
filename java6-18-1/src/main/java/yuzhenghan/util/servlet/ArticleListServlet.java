package yuzhenghan.util.servlet;

import yuzhenghan.util.JSONUtil;
import yuzhenghan.util.dao.ArticleDAO;
import yuzhenghan.util.model.Article;
import yuzhenghan.util.model.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

//@WebServlet("/articleList")
public class ArticleListServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
                   String id=req.getParameter("id");
            List<Article> articles= ArticleDAO.query(Integer.parseInt(id));
            return articles;
    }
}
