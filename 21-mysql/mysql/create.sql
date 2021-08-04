-- 创建数据库 mysql_learn
create database if not exists mysql_learn;
-- 删除数据库 mysql_learn
-- drop database if exists mysql_learn;

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

