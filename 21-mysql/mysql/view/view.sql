-- 创建视图
create view view_student as
select name
from student;

-- 使用视图
select *
from view_student;

-- 删除视图
drop view view_student;
