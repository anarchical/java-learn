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

4. 创建映射文件 StudentMapping.xml，同时在 config.xml 中声明

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



#### 底层原理



#### 常见问题

