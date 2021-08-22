create table student
(
    id       int primary key auto_increment,
    name     varchar(16) not null,
    class_id int         null,
    foreign key (class_id) references class (id)
);

-- 指定外键名添加外键
alter table student
    add constraint class_key foreign key (class_id) references class (id);

-- 删除外键
alter table student
    drop foreign key class_key;

-- 查询张三所在的班级
select *
from class
where id = (select class_id from student where name = '张三');

-- 内连接查询张三所在的班级
select *
from student
         inner join class
where student.name = '张三'
  and student.class_id = class.id;

-- 左连接查询
select *
from student
         left join class on class.id = student.class_id;

-- 右连接查询
select *
from class
         right join student on class.id = student.class_id;

-- 查询去重
select distinct *
from student;

-- 分页查询 limit index, length（起始下标，从 0 开始；length 为截取的数据量）
select *
from student
limit 10,5;