package LeetCode.JDBC;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

public class Test {
    public static void main(String[] args) {
        DataSource data=new MysqlDataSource();
    }
}
