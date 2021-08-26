-- 订单 与商品为多对多关系 与客户为一对多关系

create table orders(
    id int,
    name varchar(32),
    client_id int,
    primary key (id),
    foreign key (client_id) references client(id)
);

insert into orders values (1,'张三的第一个订单',1);
insert into orders values (2,'张三的第二个订单',1);
insert into orders values (3,'李四的第一个订单',2);
insert into orders values (4,'李四的第二个订单',2);
insert into orders values (5,'王五的第一个订单',3);
insert into orders values (6,'王五的第二个订单',3);