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
  -- 获取参数的绝对值
  select abs(-10);
  -- 获取小于参数的最大整数
  select floor(1.5);
  -- 获取大于参数的最大整数
  select ceil(1.5);
  ```

* 日期函数

  ```mysql
  -- 获取当前日期
  select curdate();
  -- 获取当前时间
  select curtime();
  -- 获取当前日期和时间
  select now();
  ```

* 高级函数

  ```mysql
  
  ```

##### 增删改查（CRUD）

* create

  ```mysql
  
  ```

* read

  ```mysql
  
  ```

* update

  ```mysql
  
  ```

* delete

  ```mysql
  
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
