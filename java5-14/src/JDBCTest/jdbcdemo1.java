package JDBCTest;






import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcdemo1 {
    public static void main(String[] args) throws Exception {
        //1.导入驱动包.
        //2注册驱动
    Class.forName("com.mysql.jdbc.Driver");
    //3.获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java0507" , "root", "2280629901");
        //4定义sql语句
        String sql="update student1 set math=100 where id=100";
        //5.获取执行sql对象
        Statement statement = conn.createStatement();
        //6.执行sql语句
        int count = statement.executeUpdate(sql);
        System.out.println(count);
        //释放资源
        statement.close();
        conn.close();
    }
}
