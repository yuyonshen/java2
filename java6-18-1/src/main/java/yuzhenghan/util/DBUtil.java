package yuzhenghan.util;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBUtil {

    private static  volatile DataSource DATA_SOURCE;

    private static final String URL="jdbc:mysql://localhost:3306/blogdemo";
    private static final String USER="root";
    private static final String PASSWORD="2280629901";

    private DBUtil() {
    }
    private static DataSource DATA_SOURCE(){
        if(DATA_SOURCE==null){
            synchronized (DBUtil.class){
                if(DATA_SOURCE==null){
                   DATA_SOURCE= new MysqlDataSource();
                    ((MysqlDataSource)DATA_SOURCE).setURL(URL);
                    ((MysqlDataSource)DATA_SOURCE).setUser(USER);
                    ((MysqlDataSource)DATA_SOURCE).setPassword(PASSWORD);
                }
            }
        }
        return DATA_SOURCE;
    }
    public static Connection getConnection()  {

        try {
            return DATA_SOURCE().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("关闭数据库连接失败",e);
        }
    }


    public static void close(Connection c, Statement s, ResultSet r){
        try {
            if(r!=null){
                r.close();
            }
            if(s!=null){
                s.close();
            }
            if(c!=null){
                c.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("关闭数据库连接失败",e);
        }
    }
    public static void close(Connection c,Statement s){

        close(c,s,null);
    }
}
