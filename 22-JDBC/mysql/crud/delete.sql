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