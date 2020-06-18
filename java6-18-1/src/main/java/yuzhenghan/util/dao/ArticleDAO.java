package yuzhenghan.util.dao;
import javafx.scene.chart.XYChart;
import yuzhenghan.util.DBUtil;
import yuzhenghan.util.model.Article;

import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;
public class ArticleDAO {


    public static List<Article> query(int id) {
        List<Article> articles=new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            //获取链接
            c= DBUtil.getConnection();
            String sql="select a.id, a.title, a.content, a.user_id, a.create_time " +
                    " from article a join user u on a.user_id = u.id where u.id = ?";
            //执行sql
            ps=c.prepareStatement(sql);
            ps.setInt(1,id);
            //处理结果集
            rs = ps.executeQuery();
            while(rs.next()){
                Article a=new Article();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setContent(rs.getString("content"));
                a.setUserId(id);
                a.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                articles.add(a);
            }
        } catch (Exception e) {
            throw  new RuntimeException("查询文章列表错误",e);
        } finally {
            //释放资源
            DBUtil.close(c,ps,rs);
        }
        return articles;
    }

    public static int insert(Article article) {
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            //获取链接
            c= DBUtil.getConnection();
            String sql="insert into article(id , title, content, user_id, create_time)\n" +
                    "values (4,'标题4', '内容4', 1, CURRENT_TIME)";
            //执行sql
            ps=c.prepareStatement(sql);

            //处理结果集
            return ps.executeUpdate();

        } catch (Exception e) {
            throw  new RuntimeException("插入文章错误",e);
        } finally {
            //释放资源
            DBUtil.close(c,ps);
        }
    }
}
