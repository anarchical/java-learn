-- 商品 与订单为多对多关系

create table commodity(
    id int,
    name varchar(32),
    primary key (id)
);

insert into commodity values (1,'吃的');
insert into commodity values (2,'喝的');
insert into commodity values (3,'玩的');
insert into commodity values (4,'穿的');
insert into commodity values (5,'看的');
insert into commodity values (6,'用的');
