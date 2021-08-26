-- 中间表，用于记录订单的商品内容 商品和订单之间为多对多关系
create table commodity_order(
    id int,
    order_id int,
    commodity_id int,
    primary key (id),
    foreign key (order_id) references orders(id),
    foreign key (commodity_id) references commodity(id)
);

insert into commodity_order values (1,1,1);
insert into commodity_order values (2,2,2);
insert into commodity_order values (3,3,3);
insert into commodity_order values (4,4,4);
insert into commodity_order values (5,5,5);
insert into commodity_order values (6,6,6);
