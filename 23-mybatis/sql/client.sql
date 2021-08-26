-- 客户 与订单为一对多关系

create table client(
    id int,
    name varchar(32),
    primary key (id)
);

insert into client values (1,'张三');
insert into client values (2,'李四');
insert into client values (3,'王五');