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