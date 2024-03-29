### MySQL

两类数据库

SQL（Structured Query Language） NoSQL（Not Only SQL）

* 关系型数据库：MySQL、Oracle、SQLServer
* 非关系型数据库：Redis、ElasticSearch、MongoDB

MySQL 是一个关系型数据库管理系统，是最好的 RDBMS（Relational Database Management System） 应用软件之一

#### RDBMS 术语

| 术语                | 意义                                                         |
| ------------------- | ------------------------------------------------------------ |
| 数据库（database）  | 一些关联表的集合                                             |
| 数据表（table)      | 数据的矩阵，二维数据结构                                     |
| 列（column）        | 一列是一组相同类型的元素                                     |
| 行（row）           | 一行是一组相关的数据                                         |
| 冗余                | 存储两倍以上的数据，降低了性能，提高了安全性                 |
| 主键（primary key） | 主键是唯一的，能够标识一行数据的唯一性                       |
| 外键（foreign key） | 外键用于关联另一张表                                         |
| 复合键              | 也叫组合键，将多个列作为一个索引键，用于复合索引             |
| 索引（index）       | 用于快速访问数据库表中的特定信息                             |
| 表头（header）      | 每一列的名称，表的属性                                       |
| 参照完整性          | 参照的完整性要求关系中不允许引用不存在的实体。<br />与实体完整性是关系模型必须满足的完整性约束条件，目的是保证数据的一致性。 |

#### 存储引擎

存储引擎是数据库各项功能（读、写、索引、锁定等）的具体技术实现，可以为每张表设置不同的存储引擎

`show engines;`

最常用的有 InnoDB 存储引擎，独有处理事务的能力

#### 数据类型

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

#### 运算符

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
  -- 逻辑非 not, !
  select not 1;
  select !0;
  -- 逻辑与 and
  select 2 and 0;
  -- 逻辑或 or
  select 1 or 0;
  -- 逻辑异或 xor
  select null xor 1;
  ```

* 位运算符

  ```mysql
  -- 按位与 &
  select 1&0;
  -- 按位或 |
  select 1|0;
  -- 按位异或 ^
  select 1^0;
  -- 按位取反 !
  select !0;
  -- 左移 <<
  select 1<<1;
  -- 右移 >>
  select 1>>1;
  ```

#### 函数

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
  -- 判断参数是否为空
  select isnull(null);
  ```

#### 索引

用于提高 mysql 检索速度；索引也是一张表，保存了索引信息和对应的记录所存在的磁盘地址

索引加快检索速度的同时，创建和维护索引也消耗了物理空间，滥用索引会导致检索速度下降

##### 索引结构

索引的底层结构为 B+ 树，原因如下：

* 二叉树：有序插入元素时，二叉树会退化成链表，并且树的高度不可控

* 红黑树：平衡二叉树，虽然能防止退化成链表，但是数据量过大的情况下树会过高，导致查询效率降低

* B 树：多路搜索树，保证树平衡的同时，降低树的高度

* B+ 树：对 B 树的优化，是一种冗余的数据结构；将数据信息只存放在叶子结点（这样非叶子节点就能存储更多的索引信息），叶子节点之间加了指针形成链表；非叶子结点只存放索引信息和数据的地址信息

  MySQL 分配给每一级的空间时 16KB，而非叶子节点的大小是 14 byte，所以非叶子节点可以存储 16KB/14 byte = 1170 个索引

  叶子节点会同时存储索引信息和数据的地址信息，每个结点占 1KB ，所以每一层能存 16 个元素

  则三层的 B+ 树结构可以存储  1170 * 1170 * 16 = 2190 w 条索引信息

##### 索引分类

* 普通索引：

  索引内容可以重复，可以为 null

* 唯一性索引：

  索引值是唯一的，索引内容可以为 null（添加主键时默认创建唯一索引，但主键索引不能为 null）

* 全文索引：

  只能创建再 char、varchar、text 数据类型的字段上，在查询数据量较大的字符串类型的字段时，可以使用全文索引提高查询效率；mysql5.6 之前 InnoDB 不支持全文索引

* 单列索引：

  把索引添加到一个字段上

* 多列索引：

  把索引添加到多个字段上

* 空间索引

  建立在空间数据类型上的索引（GIS，地理信息系统）；mysql5.7 之前 InnoDB 不支持空间索引

##### 索引的相关操作

```mysql
-- 显示索引信息 \G 用来格式化输出信息
show index from table_name;
-- 创建索引
create index index_name on table_name (column_name);
-- 创建表的时候指定索引
create table table_name
(
    id          int         not null,
    column_name varchar(16) not null,
    index index_name (id)
);
-- 修改表结构创建索引
alter table table_name
    add index index_name (column_name);
-- 删除索引
drop index index_name on table_name;
-- 创建唯一索引
create unique index index_name on table_name (column_name);
-- 创建表的时候指定唯一索引
create table table_name
(
    id          int        not null,
    column_name varchar(8) not null,
    unique index_name (column_name)
);
-- 修改表结构创建索引
alter table table_name
    add unique index index_name (column_name);
-- 创建组合索引
create index index_name on table_name (id, column_name);
-- 添加全文索引
alter table table_name
    add fulltext index_name (column_name);
```

#### 键

##### 主键（primary key）

主键是唯一的，用于标识条数据的唯一性

##### 外键（foreign key）

外键用于关联两个表；一般情况下一个表中的外键通常是另一个表中的主键

数据表之间一般有三种关系：

* 一对一：

  A表中的一条记录对应B表中的一条记录，并且B表中的一条记录也对应A表中的一条记录

  （例如人和身份证号一一对应，实际开发中一般不会使用一对一关系，完全可以合成一张表）

* 一对多：

  A表中的一条记录对应B表中的多条记录，并且B表中的一条记录对应A表中的一条记录

  （例如学生和班级，一个学生只能对应一个班级，但是一个班级可以对应多个学生）

* 多对多：

  A表中的一条记录对应B表中的多个记录，并且B表中的一个条记录也对应A表中的多条记录

  （例如选课，一个学生可以有多个课程信息，一个课程也可以有多个学生选）
###### 一对多

一般为主从关系，主表为一的一方，从表为多的一方（如学生班级关系，班级可以设置成主表，学生设置成从表）

从表中设置的外键一般为主表中的主键

```mysql
-- 生成外键
create table class(
    id int primary key auto_increment,
    name varchar(16) not null
);

create table student(
    id int primary key  auto_increment,
    name varchar(16) not null ,
    class_id int null,
    foreign key(class_id)  references class(id)
);

-- 指定外键名添加外键
alter table student
    add constraint class_key foreign key (class_id) references class (id);

-- 删除外键
alter table student
    drop foreign key student_ibfk_1;

```

实际开发中一班不生成外键约束，因为需要耗费额外的资源对约束关系进行维护，同时会导致主表中被引用的数据无法被删除

###### 多对多

多对多关系需要借助一张中间表来完成两张之间的关系映射

两张表都为主表，中间表为从表，添加两张表的主键作为外键

#### 查询

##### 多表关联查询

* 嵌套查询

  ```mysql
  -- 查询张三所在的班级
  select *
  from class
  where id = (select class_id from student where name = '张三');
  ```

* 连接查询

  * 内连接（inner join）

    也叫笛卡尔积查询，查询时将两张表的所有信息进行关联（将两张表的所有数据进行组合，通过 where 进行条件过滤）

    ```mysql
    -- 内连接查询张三所在的班级
    select *
    from student
             inner join class
    where student.name = '张三'
      and student.class_id = class.id;
    ```

  * 外连接

    * 左连接（left join）

      将左表的所有数据和右表满足条件的数据进行组合

      ```mysql
      -- 左连接查询
      select * from student left join class on class.id = student.class_id;
      ```

    * 右连接（right join）

      将右表的所有数据和左表满足条件的数据进行组合

      ```mysql
      -- 右连接查询
      select * from class right join student  on class.id = student.class_id;
      ```

##### 去重

查询时使用 distinct 关键字

```mysql
-- 查询去重
select distinct * from student;
```

##### 分页

使用 limit 关键字

```mysql
-- 分页查询 limit index, length（起始下标，从 0 开始；length 为截取的数据量）
select * from student limit 10,5;
```

#### SQL

结构化查询语言（Structured Query Language），主要分为四类

* DDL（Data Definition Language 数据定义语言）

  create、drop、alter

* DQL（Data Query Language 数据查询语言）

  select、where

* DML（Data Manipulation Language 数据操作语言）

  insert、update、delete 

* DCL / TCL（Data Control Language 数据控制语言/Transaction Control Language 事务控制语言）

  commit、rollback

#### 增删改查（CRUD）

* create

  ```mysql
  -- 创建数据库 mysql_learn
  create database if not exists mysql_learn;
  
  -- 创建课程表 course，auto_increment 表示自增，default 表示设置默认值
  create table mysql_learn.course
  (
      id   int auto_increment comment 'id唯一标识',
      name varchar(16) default '课程名',
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
  
  insert into mysql_learn.course(name)
  values ('Java 程序设计');
  
  insert into mysql_learn.course(name)
  values ('MySQL 数据库')
  ```

* read

  ```mysql
  -- 查看表结构
  desc course;
  -- 按条件查询一条数据
  select *
  from mysql_learn.course
  where id = 2;
  -- 查询一条数据
  select *
  from mysql_learn.course
  limit 1;
  -- 查询全部数据
  select *
  from mysql_learn.course;
  ```

* update

  ```mysql
  -- 新增字段
  alter table mysql_learn.course
      add teacher varchar(10);
  -- 修改字段
  alter table mysql_learn.course
      modify teacher varchar(5);
  alter table mysql_learn.course
      change teacher teachers varchar(2);
  -- 修改字段位置
  alter table mysql_learn.course
      modify teacher varchar(5) first;
  alter table mysql_learn.course
      modify teacher varchar(5) after name;
  -- 删除一列
  alter table mysql_learn.course
      drop teacher;
  -- 生成主键
  alter table course
      add constraint primary key (id);
  -- 生成自增约束
  alter table course
      modify id int auto_increment;
  -- 生成非空约束
  alter table student
      modify id int not null;
  -- 删除默认值
  alter table course
      alter column id drop default;
  -- 设置默认值
  alter table course
      alter column name set default 'course_name';
  ```

* delete

  ```mysql
  -- 删除数据库
  drop database if exists mysql_learn;
  -- 删除表
  drop table if exists mysql_learn.student;
  -- 删除一行
  delete
  from mysql_learn.course
  where id = 1;
  -- 删除主键自增约束
  alter table course modify id int;
  -- 删除主键
  alter table course
      drop constraint `PRIMARY`;
  -- 删除主键（如果主键有约束，则先删除约束）
  alter table student
      drop primary key;
  -- 删除非空约束
  alter table course
      modify id int null;
  ```

#### 视图（View）

视图就是一张虚拟的、专门用来做查询的、自定义展示数据的表

```mysql
-- 创建视图
create view view_student as
select name
from student;

-- 使用视图
select *
from view_student;

-- 删除视图
drop view view_student;
```

#### 触发器（Trigger）

触发器定义了一系列操作，可以在执行增删改查操作前后，自动执行一些操作

OLD 表示旧数据，NEW 表示新数据

```mysql
-- 创建触发器 (删除主表的数据前清空外键) 
create trigger t_before_delete_on_class
    before delete
    on class
    for each row
begin
    update student set student.class_id=null where student.class_id = OLD.id;
end;
-- 删除触发器
drop trigger t_before_delete_on_class;
```

#### 存储过程（Procedure）

存储过程是一组为了完成特定功能的 SQL 语句集合，存在数据库中供用户直接调用，类似于方法

```mysql
-- 创建存储过程，可以设置入参和出参
create procedure add_student(in name varchar(16), out num int)
begin
    insert into student(name) values (name);
    select COUNT(*) into num from student;
end;
-- 调用存储过程
call add_student('新同学', @num);
-- 获取出参信息
select @num;
-- 删除存储过程
drop procedure add_student;
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

```mysql
-- 事务
-- 开启事务
begin；
-- 执行事务内容（多条sql语句）
insert into table_name value(1);
insert into table_name value(2);
-- 回滚事务
rollback;
-- 提交事务
commit;
```

#### 备份和恢复

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



#### 常见问题

