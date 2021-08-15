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

delete from class where id=1;