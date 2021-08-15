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
