package JDBCTest;

import java.sql.*;

public class jdbcDemo4 {
    public static void main(String[] args) throws Exception {
   //查看这个变得所有记录
        Class.forName("com.mysql.jdbc.Driver");
        //获取数据库连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql:///java0507", "root", "2280629901");
        String sql="select * from student1";
        //获取执行sql语句对象
        Statement statement = connection.createStatement();
        //执行sql语句
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            int id=resultSet.getInt("id");
            int math=resultSet.getInt("math");
            int chinese=resultSet.getInt("chinese");
            System.out.println("id="+id+" "+"math="+math+" "+"chinese="+chinese);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
