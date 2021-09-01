### MyBatis

MyBatis 是目前主流的 ORM（Object Relationship Mapping）框架之一；对象关系映射，用于将数据库中的记录转换成 java 对象

常见的 ORM 框架还有：Hibernate、Spring Data JPA、MyBatis Plus

* 优点

  简化 JDBC 代码的开发

  具有很高的灵活性

  SQL 写到 XML 中，与代码解耦

  支持动态 SQL

* 缺点

  XML 配置繁琐

  需要要求开发人员具备一定的 SQL 能力

  数据库移植性差，需要重新编写 SQL

#### 基本使用（原生接口）

1. 导入 MyBatis 依赖 pom.xml

   ```xml
   <dependencies>
       <!--mybatis 依赖-->
       <dependency>
           <groupId>org.mybatis</groupId>
           <artifactId>mybatis</artifactId>
           <version>3.5.7</version>
       </dependency>
       <!--mysql 驱动依赖，两者必须配合使用-->
       <dependency>
           <groupId>mysql</groupId>
           <artifactId>mysql-connector-java</artifactId>
           <version>8.0.25</version>
       </dependency>
   </dependencies>
   ```

2. 配置数据源 config.xml，并声明 映射 Mapper.xml 文件

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE configuration
           PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-config.dtd">
   
   <configuration>
       <environments default="development">
           <environment id="development">
               <transactionManager type="JDBC"/>
               <dataSource type="POOLED">
                   <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                   <property name="url" value="jdbc:mysql://192.168.173.100:3306"/>
                   <property name="username" value="root"/>
                   <property name="password" value="123456"/>
               </dataSource>
           </environment>
       </environments>
   
       <!--声明映射文件 StudentMapper.xml-->
       <mappers>
           <mapper resource="mapper/StudentMapper.xml"/>
       </mappers>
   </configuration>
   ```

3. 创建实体类

   ```java
   @SuppressWarnings("unused")
   public class Student {
   
       private int id;
       private String name;
   
       public Student() {
       }
   
       public Student(int id, String name) {
           this.id = id;
           this.name = name;
       }
   
       public int getId() {
           return id;
       }
   
       public void setId(int id) {
           this.id = id;
       }
   
       public String getName() {
           return name;
       }
   
       public void setName(String name) {
           this.name = name;
       }
   
       @Override
       public String toString() {
           return "Student{" +
                   "id=" + id +
                   ", name='" + name + '\'' +
                   '}';
       }
   }
   ```

4. 创建映射文件 StudentMapping.xml，同时在 config.xml 中声明注册

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE mapper
           PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
   
   <mapper
           namespace="mapper.StudentMapper">
       <select id="findById" parameterType="int" resultType="entity.Student">
           select *
           from mysql_learn.student
           where id = #{id}
       </select>
   </mapper>
   ```

5. 调用原生接口执行 SQL 获取结果

   ```java
   public class StudentService {
   
       public static void main(String[] args) {
   
           //加载配置文件 config.xml
           InputStream inputStream = StudentService.class.getClassLoader().getResourceAsStream("config.xml");
           SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
           SqlSessionFactory factory = builder.build(inputStream);
           //开启连接会话
           SqlSession sqlSession = factory.openSession();
           //指定查询语句，由 namespace + id 构成
           String statement = "mapper.StudentMapper.findById";
           //执行sql，传入参数
           Student student = sqlSession.selectOne(statement, 2);
           System.out.println(student);
       }
   }
   ```

注：maven 工程默认无法读取 src 中的资源文件，需要在 pom.xml 额外配置开放权限

如果抛出错误 `java: 警告: 源发行版 11 需要目标发行版 11`，则需要在 pom.xml  build中声明 JDK 版本

```xml
<build>
    <!--让 maven 工程能够读取到 src/main/java 目录下的资源文件，默认只能从 resources 目录下读取-->
    <!--** 表示任意级目录，* 表示任意文件-->
    <resources>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.xml</include>
            </includes>
        </resource>
    </resources>
    <!--IDEA 的 maven 插件默认只支持 jdk11，需要手动声明 jdk8-->
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.1</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
            </configuration>
        </plugin>
    </plugins>
</build>
```

#### 自定义接口

原生接口使用起来复杂，耦合度高；通过声明接口， Dao 层与 Service 层解耦；

mybatis 会自动实现接口的内容，无需手动实现

1. 创建映射文件 StudentMapping.xml，同时在 config.xml 中声明注册

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE mapper
           PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
   <!--namespace 指定所映射的接口-->
   <mapper namespace="mapper.StudentMapper">
   
       <select id="findById" parameterType="int" resultType="entity.Student">
           select *
           from mysql_learn.student
           where id = #{id};
       </select>
   
       <select id="findAll" resultType="entity.Student">
           select *
           from mysql_learn.student;
       </select>
   
       <select id="save" parameterType="entity.Student">
           insert into mysql_learn.student
           values (#{id}, #{name});
       </select>
   
       <select id="update" parameterType="entity.Student">
           update mysql_learn.student
           set name=#{name}
           where id = #{id};
       </select>
   
       <select id="deleteById" parameterType="java.lang.Integer">
           delete
           from mysql_learn.student
           where id = #{id};
       </select>
   
   </mapper>
   ```

2. 创建接口 StudentMapper，接口的名称需要和 Mapper 映射文件中的 namespace 对应；接口的抽象方法名称需要和 Mapper 映射文件中 `<select>` 标签中的 id 值对应

   ```java
   public interface StudentMapper {
   
       Student findById(int id);
   
       List<Student> findAll();
   
       void save(Student student);
   
       void deleteById(int id);
   
       void update(Student student);
   }
   ```

3. 获取代理对象，直接调用方法执行 mybatis 底层实现好的 sql

   ```java
   public class StudentService {
   
       public static void main(String[] args) {
   
           //加载配置文件 config.xml
           InputStream inputStream = StudentService.class.getClassLoader().getResourceAsStream("config.xml");
           SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
           SqlSessionFactory factory = builder.build(inputStream);
           //开启连接会话
           SqlSession sqlSession = factory.openSession();
   
           //获取接口的实现(获取代理对象)
           StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
   
           //增删改查
           mapper.save(new Student(100, "student"));
           Student student = mapper.findById(100);
           System.out.println(student);
   
           mapper.update(new Student(100, "new Student"));
           List<Student> studentList = mapper.findAll();
           System.out.println(studentList);
   
           mapper.deleteById(100);
       }
   }
   ```

注：当数据库的字段名和所需要映射的实体类的字段名不一样时，则需要声明映射关系

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--namespace 指定所映射的接口-->
<mapper namespace="mapper.StudentMapper">

    <!--当数据库中的 column 名称与实体类中的 属性名不一致时，则需要手动声明指定映射关系 resultMap-->
    <resultMap id="studentMap" type="entity.Student">
        <result property="id" column="id"/>
        <result property="name" column="name"/>
    </resultMap>

    <!--resultMap 需要在查询语句中绑定，替换resultType-->
    <select id="findById" parameterType="int" resultMap="studentMap">
        select *
        from mysql_learn.student
        where id = #{id};
    </select>

</mapper>
```

#### 底层原理

mybatis 通过 xml 配置文件解析（dom 解析）和使用反射的动态代理功能实现了一整套自定义接口功能

#### 使用详解



##### 多表关联查询

1. 一对一查询

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE mapper
           PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
   <mapper namespace="mapper.OrderMapper">
   
       <resultMap id="orderMap" type="entity.Order">
           <id column="oid" property="id"/>
           <result column="oname" property="name"/>
           <!--一对一关系-->
           <association property="client" javaType="entity.Client">
               <id column="cid" property="id"/>
               <result column="cname" property="name"/>
           </association>
       </resultMap>
   
   
       <select id="findOrderAndClientByOrderId" parameterType="java.lang.Integer" resultMap="orderMap">
           select client.id cid, client.name cname, orders.id oid, orders.name oname
           from mysql_learn.client client,
                mysql_learn.orders orders
           where orders.id = #{id}
             and orders.client_id = client.id;
       </select>
   
   </mapper>
   ```

2. 一对多

   一方

   ```java
   @Data
   public class Client {
       private Integer id;
       private String name;
       private List<Order> orders;
   }
   ```

   多方

   ```java
   @Data
   public class Order {
       private Integer id;
       private String name;
       private Client client;
   }
   ```

   映射文件

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE mapper
           PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
   <!--namespace 指定所映射的接口-->
   <mapper namespace="mapper.ClientMapper">
   
       <resultMap id="clientMap" type="entity.Client">
           <id column="cid" property="id"/>
           <result column="cname" property="name"/>
           <collection property="orders" ofType="entity.Order">
               <id column="oid" property="id"/>
               <result column="oname" property="name"/>
           </collection>
       </resultMap>
   
       <select id="findById" parameterType="java.lang.Integer" resultMap="clientMap">
           select client.id cid, client.name cname, orders.id oid, orders.name oname
           from mysql_learn.client client,
                mysql_learn.orders orders
           where client.id = #{id}
             and orders.client_id = client.id;
       </select>
   
   </mapper>
   ```


#### 延迟加载

延迟加载（懒加载）将某写查询操作滞后，尽量减少 SQL 的执行，提高性能

延迟加载只存在于级联查询中，单表查询没有延迟加载的功能

开启延迟加载设置

```xml
    <settings>
        <!--设置控制台打印 sql-->
        <setting name="logImpl" value="STDOUT_LOGGING"/>
        <!--开区延迟加载-->
        <setting name="lazyLoadingEnabled" value="true"/>
    </settings>
```

延迟加载功能的映射文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="mapper.OrderMapper">

    <!--懒加载写法-->
    <resultMap id="orderMap" type="entity.Order">
        <id column="oid" property="id"/>
        <result column="oname" property="name"/>
        <!--一对一关系-->
        <association property="client" javaType="entity.Client" select="mapper.ClientMapper.findById"
                     column="client_id"/>
    </resultMap>

    <!--懒加载写法-->
    <select id="findOrderAndClientByOrderId" parameterType="java.lang.Integer" resultMap="orderMap">
        select orders.id oid, orders.name oname, orders.client_id
        from mysql_learn.orders orders
        where orders.id = #{id}
    </select>

</mapper>
```

```java
        //只执行一条 SQL
				Order order = mapper.findOrderAndClientByOrderId(2);
        System.out.println(order.getName());
				//执行两条 SQL
				Order order = mapper.findOrderAndClientByOrderId(2);
        System.out.println(order.getClient().getName());
```

#### 缓存机制

缓存机制可以解决单表查询时的性能问题

通过缓存机制可以使得 Java 程序与数据库进行尽量少的交互，提高运行性能。

当 MyBatis 查询出结果后，会自动将其存入缓存中，下一次查询则直接访问缓存，而不是数据库，从而提升性能；

当执行增删改等操作时，删除缓存，从而保证数据的时效性

##### 一级缓存

MyBatis 默认自带一级缓存且无法关闭

一级缓存的数据存储在 SqlSession 中，同一个 SqlSession 中所缓存查询结果被共享，不同之间的 SqlSession 中的缓存结果不能被互相访问

##### 二级缓存

二级缓存的作用域为一个 Mapper，当多个 SqlSession 使用同一个 Mapper 时，可以共享其中的缓存数据

二级缓存可以配置回收策略、缓存数量、定时清楚缓存等相关配置

配置文件中开启二级缓存

```xml
        <!--开启二级缓存-->
        <setting name="cacheEnabled" value="true"/>
```

Mapper.xml 映射文件中配置二级缓存

```xml
    <cache/>
```

使用场景：

* 当多个 namespace 去操作一个表，有的执行了新增操作刷新的缓存，但是有的没有，就会出现脏读的情况，此时需要开启二级缓存 使用 cache-ref 来共享缓存数据
* 二级缓存适用于读操作多的应用

注意：当事务被提交或者 session 被关闭时，相关数据才能被加载进二级缓存

#### 动态 SQL

当业务中存在大量相同的 SQL 时，SQL 语句的复用性很差，则可以通过动态 SQL 来实现解耦

以下 SQL 相同部分过多

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.mapper.UserMapper">

    <select id="findByUser" resultType="com.domain.User">
        select * from user where id = #{id} and username = #{username}
    </select>

    <select id="findByUser2" resultType="com.domain.User">
        select * from user where password = #{password} and username = #{username}
    </select>

    <select id="findByUser3" resultType="com.domain.User">
        select * from user where password = #{password} and age = #{age}
    </select>

</mapper>
```

优化

```xml
<select id="findByUser" resultType="com.domain.User">
    select * from user
    <where>
        <if test="id != null">
            id = #{id}
        </if>
        <if test="username != null">
            and username = #{username}
        </if>
        <if test="password != null">
            and password = #{password}
        </if>
        <if test="age != null">
            and age = #{age}
        </if>
    </where>
</select>
```

#### 常见问题

