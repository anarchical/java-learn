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
