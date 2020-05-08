package JDBC;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    //数据库的增加元素
    private static void InsertTest() throws SQLException {
        DataSource dataSource=new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java0507?characterEncoding=utf8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("2280629901");
        //数据可的链接
        Connection connection=dataSource.getConnection();
        //拼装sql语句
        String sql="insert into student values(?,?)";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,"小明");
        statement.setInt(2,21);
        System.out.println(statement);
        int ret =statement.executeUpdate();
        System.out.println(ret);
        statement.close();
        connection.close();
    }
    //查询数据库
    private static void selectTest() throws SQLException {
        DataSource dataSource=new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java0507?characterEncoding=utf8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("2280629901");
        Connection connection=dataSource.getConnection();
        String sql="select * from student";
        PreparedStatement statement=connection.prepareStatement(sql);
        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            String name=resultSet.getString("name");
            int age=resultSet.getInt("age");
            System.out.println(name+ " :"+ age);
        }
        resultSet.close();
        statement.close();
        connection.close();

    }

    public static void main(String[] args) throws SQLException {
        //InsertTest();
        selectTest();
    }
}
