package JDBCTest2;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JDBCDemo {

    public List<student2> findAll(){
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        List<student2> list=null;

        //1.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接数据库连接对象
            connection = DriverManager.getConnection("jdbc:mysql:///java14", "root", "2280629901");
            //3.构造sql语句
            String sql="select * from student2";
            //获取执行sql语句对象
            statement = connection.createStatement();
            //执行sql语句
             resultSet = statement.executeQuery(sql);
             list=new ArrayList<>();
            student2 st=null;
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String Vegetable = resultSet.getString("Vergetable");
                double Price = resultSet.getDouble("Price");
                st=new student2();
                st.setId(id);
                st.setVegetable(Vegetable);
                st.setPrice(Price);
                list.add(st);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                resultSet.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return list;
    }

    public static void main(String[] args) {
        List<student2> all = new JDBCDemo().findAll();
        System.out.println(all);
    }
}
