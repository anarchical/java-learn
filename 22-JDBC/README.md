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

```java
package transaction;

import org.apache.commons.dbutils.QueryRunner;
import pool.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author YeYaqiao
 */
public class Transaction {

    public static void main(String[] args) throws SQLException {

        String sql = "insert into mysql_learn.course(id, name) VALUES (?,?)";

        QueryRunner queryRunner = new QueryRunner();
        Connection connection = ConnectionPool.getConnection();

        //关闭自动提交，开启事务
        connection.setAutoCommit(false);

        try {
            queryRunner.update(connection, sql, 1, "Python 编程思想");
//            System.out.println(10/0);
            queryRunner.update(connection, sql, 2, "GoLang 编程思想");
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
            //事务回滚
            connection.rollback();
        }
        connection.close();
    }
}
```

#### 连接池

每次与数据库建立连接时，都会消耗 CPU、网络资源

建立一个存放连接信息的缓冲池，避免重复连接数据库，做到资源的重复利用

数据库连接池中会存放一定数量的连接，当连接池中的连接全部都被占用时，请求就会进入等待队列，等待其它线程释放连接

常用的有 Druid 连接池、C3P0 连接池

```java
public class ConnectionPool {

    //读取配置文件
    private static final InputStream INPUT_STREAM = ConnectionPool.class.getResourceAsStream("/druid.properties");
    private static final Properties PROPERTIES = new Properties();

    private static DataSource DATA_SOURCE = null;

    //加载配置文件
    static {
        try {
            PROPERTIES.load(INPUT_STREAM);
            DATA_SOURCE = DruidDataSourceFactory.createDataSource(PROPERTIES);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DATA_SOURCE.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
```

配置文件 resources/druid.properties

```properties
#驱动名称，mysql8以后可以不声明
driverClassName=com.mysql.cj.jdbc.Driver
#数据库地址
url=jdbc:mysql://192.168.173.100:3306
#用户名
username=root
#密码
password=123456
#初始化时建立物理连接的个数 默认为0
initialSize=1
#最大连接池数量 默认为8
maxActive=8
#最小连接池数量
minIdle=1
```

#### DBUtils

DBUtils 时 Apache 开源的一个数据工具类

主要核心类有 QueryRunner 查询类、ResultSetHandler 结果处理集类（通过反射将查询到的信息封装成 Java 对象）

BeanHandler 接收单个结果、BeanListHandler 接收结果集

```java
public class DBUtils {

    public static void main(String[] args) throws SQLException {

        String sqlCourse = "select * from mysql_learn.course";

        String sqlCourseById = "select * from mysql_learn.course where id = ?";


        Connection connection = ConnectionPool.getConnection();
        QueryRunner queryRunner = new QueryRunner();

        //使用 BeanListHandler 接收查询的结果
        List<Course> courseList = queryRunner.query(connection, sqlCourse, new BeanListHandler<>(Course.class));

        //使用 BeanListHandler 接收查询的结果，并且传入查询参数，底层使用的还是 PreparedStatement 占位符
        Course course = queryRunner.query(connection, sqlCourseById, new BeanHandler<>(Course.class), 1);

        System.out.println(Arrays.toString(courseList.toArray()));
        System.out.println(course);
    }
}
```

#### 常见问题

1. 常见的MySQL存储引擎？
   * InnoDB：
   * MyISAM：
