### JDBC

Java DataBase Connection

java 语言连接数据库的一种技术，独立于特定数据库的管理系统；定义了一组标准，为访问不同的数据库提供了统一的途径

JDBC 接口包括两个层面：

1. 面向应用的 API，供程序员开发调用
2. 面向数据库的 API，供数据库厂商适配调用

#### 使用流程

1. 加载驱动

   加载 mysql 连接驱动，Mysql8 以后不需要显示声明加载驱动

2. 获取 Connection 连接

   设置 mysql 的地址、端口、用户名、密码

3. 创建 Statement，执行 SQL 语句

   execute 方法放回 boolean 类型，不是表示 sql 是否执行成功，而是表示返回的结果是否为 ResultSet 类型

   实际开发中用 PreparedStatement 替代 Statement，提供占位符功能，避免拼接字符串，防止 SQL 注入；

   预编译 sql，提高执行效率

4. 获取 ResultSet 查询结果

   ResultSet 用于保存 Statement 执行查询后的结果（增、删、改操作不需要 ResultSet）

```java
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
```

#### 事务

Transaction，指访问并可能更新数据库中各种数据项的一个程序执行单元

某个业务执行多条 SQL 时，要么全部执行成功，要么全部执行失败

* 概念

  在关系数据库中，一个事务可以是一条SQL语句，一组SQL语句或整个程序

* 特性

  原子性：一个事务执行要么全部成功，要么全部失败

  一致性：事务执行前后的数据达到预期

  隔离性：事务的执行之间互不影响；事务隔离（读未提交、读提交、可重复读、串行化）

  持久性 （ACID）：事务处理结束后，对数据的修改是永久的



#### 常见问题

