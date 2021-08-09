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

mysql 数据类型分为 数值类型、日期和时间类型、字符串类型

* 数值类型

  | 类型名    | 描述           |
  | --------- | -------------- |
  | tinyint   | 小整数值       |
  | smallint  | 大整数值       |
  | mediumint | 大整数值       |
  | int       | 大整数值       |
  | bigint    | 极大整数值     |
  | float     | 单精度浮点小数 |
  | double    | 双精度浮点小数 |
  | decimal   | 高精度小数     |

* 日期和时间类型

  | 类型名    | 描述               |
| --------- | ------------------ |
  | date      | 日期值             |
| time      | 时间值             |
  | year      | 年份值             |
| datetime  | 混合日期时间年份值 |
  | timestamp | 时间戳             |

* 字符串类型

  | 类型名     | 描述                            |
| ---------- | ------------------------------- |
  | char       | 定长字符串                      |
| varchar    | 变长字符串                      |
  | tinyblob   | 不超过 255 个字符的二进制字符串 |
| tinytext   | 短文本字符串                    |
  | blob       | 二进制形式的长文本数据          |
| text       | 长文本数据                      |
  | mediumblob | 二进制形式的中等长度文本数据    |
| mediumtext | 中等长度文本数据                |
  | longblob   | 二进制形式的极大文本数据        |
| longtext   | 极大文本数据                    |

##### 运算符

* 算术运算符

  ```mysql
  -- 加法
  select 1+2;
  -- 减法
  select 2-1;
  -- 乘法
  select 2*3;
  -- 除法(div 保留整数，/ 保留4位小数)
  select 4/2;
  select 4 div 2;
  -- 取余
  select 10 mod 3;
  ```

* 比较运算符

  ```mysql
  -- 0 表示 false，1 表示 true
  -- 等于 = （有一边为则结果为 NULL ）
  select 1 = 2;
  -- 不等于 <>, !=
  select 1 <> 2;
  select 1 != 2;
  -- 安全等于 <=> （当两边为 NULL 时，结果为 1，有一边为 NULL 时，结果为 0）
  select null <=> null;
  -- 小于 <
  select 1 < 2;
  -- 小于等于 <=
  select 1 <= 2;
  -- 大于 >
  select 1 > 2;
  -- 大于等于 >=
  select 1 >= 2;
  -- 在两值之间 between
  select 3 between 1 and 5;
  -- 不在两值之间 not between
  select 3 not between 1 and 5;
  -- 在集合中 in
  select 5 in (1, 2, 3, 4, 5, 6);
  -- 不在集合中 not in
  select 5 not in (1, 2, 3, 4, 5, 6);
  -- 模糊匹配 like
  select 'mysql' like '%sql';
  -- 正则匹配 regexp, rlike
  select 'mysql' regexp 'sql';
  -- 为空 is null
  select null is null;
  -- 不为空 is not null
  select null is not null;
  ```

* 逻辑运算符

  ```mysql
  
  ```

* 位运算符

  ```mysql
  
  ```

##### 函数

* 字符串函数

  ```mysql
  -- 字符串 s2 替换 s1 的 x 位置开始长度为 len 的字符串（以1位开头，而不是0）
  select insert('hello world', 7, 5, 'mysql');
  -- 将字母转为大写
  select upper('string');
  -- 将字母转为小写
  select lower('STRING');
  -- 获取字符串 s 前 len 个字符
  select left('hello world', 5);
  -- 获取字符串 s 后 len 个字符
  select right('hello world', 5);
  -- 从 index 开始截取 len 个字符
  select substring('hello world', 5, 3);
  -- 获取字符串的逆序
  select reverse('hello world');
  ```

* 数字函数

  ```mysql
  -- 获取参数的绝对值 abs
  select abs(-10);
  -- 获取小于参数的最大整数 floor
  select floor(1.5);
  -- 获取大于参数的最小整数 ceil
  select ceil(1.5);
  -- 获取查询结果指定字段的总记录数 count
  select count(name) from mysql_learn.course;
  -- 计算某个字段的总和 sum
  select sum(id) from mysql_learn.course;
  -- 计算某个字段的平均值
  select avg(id) from mysql_learn.course;
  -- 获取某个字段所有记录中的最大值
  select max(id) from mysql_learn.course;
  -- 获取某个字段所有记录中的最小值
  select min(id) from mysql_learn.course;
  ```

* 日期函数

  ```mysql
  -- 获取当前日期
  select curdate();
  -- 获取当前时间
  select curtime();
  -- 获取当前日期和时间
  select now();
  -- 获取指定日期n天后的日期
  select adddate('2020-01-01',100);
  -- 获取指定日期n天前的日期
  select subdate('2020-04-10',100);
  -- 获取两天之间相隔的天数
  select datediff('2020-04-10','2020-01-01');
  ```

* 高级函数

  ```mysql
  
  ```

##### 增删改查（CRUD）

* create

  ```mysql
  -- 创建数据库 mysql_learn
  create database if not exists mysql_learn;
  
  -- 创建课程表 course
  create table mysql_learn.course
  (
      id   int,
      name varchar(2),
      primary key (id)
  ) engine = InnoDB
    default charset = utf8;
  
  -- 创建学生表 student
  create table mysql_learn.student
  (
      id   int,
      name varchar(3),
      primary key (id)
  );
  
  -- 插入数据
  insert into mysql_learn.student(id, name)
  values (2, '张三');
  ```

* read

  ```mysql
  -- 按条件查询一条数据
  select * from mysql_learn.course where id = 2;
  -- 查询一条数据
  select * from mysql_learn.course limit 1;
  -- 查询全部数据
  select * from mysql_learn.course;
  ```

* update

  ```mysql
  -- 新增字段
  alter table mysql_learn.course add teacher varchar(10);
  -- 修改字段
  alter table mysql_learn.course modify teacher varchar(5);
  alter table mysql_learn.course change teacher teachers varchar(2);
  -- 修改字段位置
  alter table mysql_learn.course modify teacher varchar(5) first ;
  alter table mysql_learn.course modify teacher varchar(5) after name;
  -- 删除一列
  alter table mysql_learn.course drop teacher;
  ```

* delete

  ```mysql
  -- 删除数据库
  drop database if exists mysql_learn;
  -- 删除表
  drop table if exists mysql_learn.student;
  -- 删除一行
  delete from mysql_learn.course where id = 1;
  ```

##### 索引

用于提高 mysql 检索速度；索引也是一张表，保存了主键和索引字段

索引的底层结构为 B+ 树

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
