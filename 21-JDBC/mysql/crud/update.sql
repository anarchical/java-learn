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