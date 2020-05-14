package JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcDemo2 {
    //执行查看数据库
    public static void main(String[] args) throws Exception {
        //首先注册驱动(可以省略不写)
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取数据库连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java0507", "root", "2280629901");
        //创建sql语句
        String sql="select * from student1";
        //创建sql执行语句对象
        Statement statement = connection.createStatement();
        //执行sql语句
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println(resultSet);

        resultSet.close();
        statement.close();
        connection.close();
    }
}
