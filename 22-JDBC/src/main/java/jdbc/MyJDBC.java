package jdbc;

import java.sql.*;

/**
 * @author YeYaqiao
 */
public class MyJDBC {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://192.168.173.100:3306";
        String username = "root";
        String password = "123456";

        String sql = "select * from mysql_learn.course";

        //加载驱动，mysql8 以后会自动加载驱动，不需要显示声明
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取 Connection 连接
        Connection connection = DriverManager.getConnection(url, username, password);
        //创建 Statement 执行 SQL 语句
        Statement statement = connection.createStatement();
        //获取 ResultSet 结果集
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            //根据字段名获取相应数据
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");

            System.out.println("id:" + id + " name:" + name);
        }

        String insertSql = "insert into mysql_learn.student(id,name) values (?,?)";
        //预编译 SQL，减少 SQL 的执行，同时使用占位符可以防止 SQL 注入攻击
        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
        preparedStatement.setInt(1, 3);
        preparedStatement.setString(2, "王五");
        int i = preparedStatement.executeUpdate();

        System.out.println(i);

        resultSet.close();
        preparedStatement.close();
        statement.close();
        connection.close();
    }
}
