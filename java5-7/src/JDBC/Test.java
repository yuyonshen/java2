package JDBC;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Test {
//    private static void testInsert() throws SQLException {
//        ///1.首先做好准备工作,现在数据库中创建好数据库和表.
//        //2.再创建 DataSource对象.
//        DataSource source=new MysqlDataSource();
//        //3.设置source的属性,为数据库的链接做好准备.
//        //MySQL是一个服务器,链接服务器需要主导服务器的ip,和端口号.
//        //以及访问的数据库名和用户名,鸡齐全密码.
//        ((MysqlDataSource)source).setURL("jdbc:mysql://127.0.0.1:3306/java0507?characterEncoding=utf8&useSSL=true");
//        ((MysqlDataSource)source).setUser("root");
//        ((MysqlDataSource) source).setPassword("2280629901");
//        //4.创建Connection对象,用来表示数据库的链接.
//        Connection connection=source.getConnection();
//        //5.对数据库的语句进行拼装.
//        String sql ="select into student values(余,23)";
//        //6.statement 用来辅助拼装 SQL 的, setXXX 的类型需要和数据库表的类型匹配.
//        PreparedStatement statement= connection.prepareStatement(sql);
//        System.out.println(statement);
//        //7.执行aql语句
//        int ret =  statement.executeUpdate();
//        System.out.println(ret);
//        //8,释放资源
//        statement.close();
//        connection.close();
        private static void testInsert() throws SQLException {
            // 0. 准备工作, 需要先在数据库中创建好数据库和数据表
            // 1. 创建 DataSource 对象, 这个对象是 "程序级" , 每个程序创建一个 DataSource 对象即可.
            //    "单例"
            DataSource dataSource = new MysqlDataSource();
            // 2. 设置 dataSource 的属性, 为和数据库建立链接做准备.
            //    MySQL 是个服务器. 要想访问 MySQL, 需要知道 MySQL 的 ip 地址, 端口号,
            //    以及要访问的数据库名, 以及用户名和密码.
            ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java0507?characterEncoding=utf8&useSSL=true");
            ((MysqlDataSource)dataSource).setUser("root");
            ((MysqlDataSource)dataSource).setPassword("2280629901");
            // 3. 创建 Connection 对象, 用来表示和数据库建立了一次链接.
            Connection connection = dataSource.getConnection();
            // 4. 如果链接建立的没啥问题, 就可以操作数据库了. 核心就是拼装 SQL 语句
            //    ?  是占位符, 可以把具体的变量替换到 ? 位置上.
            //    此处 SQL 是可以没有 ; 的.
            //    拼装 SQL 并没有真的执行 SQL.
            String sql = "insert into student values(?, ?)";
            // statement 用来辅助拼装 SQL 的, setXXX 的类型需要和数据库表的类型匹配.
            // ? 的下标从 1 开始计算
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "蔡徐坤");
            statement.setInt(2, 20);
            System.out.println(statement);
            // 5. 执行 SQL
            int ret = statement.executeUpdate();
            System.out.println(ret);
            // 6. 释放相关资源, 一定是先释放 statement, 再释放 Connection, 顺序不嫩搞错.
            statement.close();
            connection.close();

    }
    //查询操作
    private static void testSelect() throws SQLException {
            DataSource dataSource=new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java0507?characterEncoding=utf8&useSSL=true");
        ((MysqlDataSource)dataSource).setPassword("2280629901");
        Connection connection=dataSource.getConnection();
        String sql="select * from student";
        PreparedStatement statement=connection.prepareStatement(sql);

        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            String name=resultSet.getString("name");
            int age =resultSet.getInt("age");
            System.out.println(name+": "+age);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    public static void main(String[] args) throws SQLException {
        testSelect();
            //testInsert();
    }
}
