package Thread;

import jdk.nashorn.internal.ir.CallNode;

import javax.sql.DataSource;
import java.sql.*;

public class JBDC {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3","root","228062901");
        String str="select * from student";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(str);
        
    }
}
