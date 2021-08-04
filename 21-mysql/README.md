### 数据库

两类数据库

SQL（Structured Query Language） NoSQL（Not Only SQL）

* 关系型数据库：MySQL、Oracle、SQLServer
* 非关系型数据库：Redis、ElasticSearch、MongoDB
#### MySQL

是一个关系型数据库管理系统，是最好的 RDBMS（Relational Database Management System） 应用软件之一

##### 存储引擎

存储引擎是数据库各项功能（读、写、索引、锁定等）的具体技术实现，可以为每张表设置不同的存储引擎

`show engines;`

最常用的有 InnoDB 存储引擎，独有处理事务的能力

##### 数据类型

| 类型 | 大小 | 范围（有符号） | 范围（无符号） | 用途 |
| ---- | ---- | -------------- | -------------- | ---- |
|      |      |                |                |      |
|      |      |                |                |      |
|      |      |                |                |      |
|      |      |                |                |      |
|      |      |                |                |      |
|      |      |                |                |      |
|      |      |                |                |      |
|      |      |                |                |      |



##### 运算符

```mysql

```

##### 函数

```mysql
```



##### 事务

Transaction，指访问并可能更新数据库中各种数据项的一个程序执行单元

* 概念

  在关系数据库中，一个事务可以是一条SQL语句，一组SQL语句或整个程序

* 特性

  原子性、一致性、隔离性、持久性 （ACID）

##### 备份和恢复

* 备份 (mysqldump)

  ```shell
  # 备份单个数据库，包括(库、表、数据)
  mysqldump -u username -p --databases dbname > /path/back.sql
  ```

* 恢复 (mysql)

  ```shell
  # 执行导入 .sql 文件
  mysql -u username -p < /path/back.sql
  ```

#### JDBC

Java DataBase Connection

java 语言连接数据库的一种技术
