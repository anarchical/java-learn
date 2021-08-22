-- 创建数据库 mysql_learn
create database if not exists mysql_learn;

-- 创建课程表 course，auto_increment 表示自增，default 表示设置默认值
create table mysql_learn.course
(
    id   int auto_increment comment 'id唯一标识',
    name varchar(32) default '课程名',
    primary key (id)
) engine = InnoDB
  default charset = utf8;

-- 创建学生表 student
create table mysql_learn.student
(
    id   int,
    name varchar(32),
    primary key (id)
);

-- 插入数据
insert into mysql_learn.student(id, name)
values (2, '张三');

insert into mysql_learn.course(name)
values ('Java 程序设计');

insert into mysql_learn.course(name)
values ('MySQL 数据库');
