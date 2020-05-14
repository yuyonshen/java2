package JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcDemo3 {
    public static void main(String[] args) throws Exception {
        //执行增加sql语句操作
        Class.forName("com.mysql.jdbc.Driver");
        //链接数据库,获取Conn对象
        Connection connection = DriverManager.getConnection("jdbc:mysql:///java0507", "root", "2280629901");
        String sql="insert into student1 values(200,60,70)";
        //获取执行sql语句对象
        Statement statement = connection.createStatement();
        //执行sql语句
        int i = statement.executeUpdate(sql);
        if(i>0){
            System.out.println("执行成功");
        }else{
            System.out.println("执行失败");
        }
        statement.close();
        connection.close();
    }
}
