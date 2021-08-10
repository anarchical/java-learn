-- 显示索引信息 \G 用来格式化输出信息
show index from table_name;
-- 创建索引
create index index_name on table_name (column_name);
-- 创建表的时候指定索引
create table table_name
(
    id          int         not null,
    column_name varchar(16) not null,
    index index_name (id)
);
-- 修改表结构创建索引
alter table table_name
    add index index_name (column_name);
-- 删除索引
drop index index_name on table_name;
-- 创建唯一索引
create unique index index_name on table_name (column_name);
-- 创建表的时候指定唯一索引
create table table_name
(
    id          int        not null,
    column_name varchar(8) not null,
    unique index_name (column_name)
);
-- 修改表结构创建索引
alter table table_name
    add unique index index_name (column_name);
-- 创建组合索引
create index index_name on table_name (id, column_name);
-- 添加全文索引
alter table table_name
    add fulltext index_name (column_name);