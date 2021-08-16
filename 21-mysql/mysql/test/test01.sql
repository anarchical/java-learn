# 现有图书管理数据库的三个关系模式，他们的字段分别如下：
#   图书表：总编号, 分类号, 书名, 作者, 出版单位, 单价
#   读者表：借书证号, 单位, 姓名, 性别, 职称, 地址
#   借阅表：借书证号, 总编号, 借书日期
#   以上表对应的字段明细如下：
#    book ：
#      b_no ，b_type ，b_name ， b_author ，b_publish ，b_price
#    reader ：
#      r_no ,  r_unit  , r_name  ,r_sex  ,r_pro  ,r_address
#    borrow ：
#      r_no  , b_no  ,b_time

-- 1、	找出藏书中各个出版社的册数、价值总额
select count(b_no), sum(b_price), b_publish
from book
group by b_publish;

-- 2、求出各个出版社图书的最高价格、最低价格和册数
select b_publish, count(b_no), max(b_price), min(b_price)
from book
group by b_publish;

-- 3、查找所有借了书的读者的姓名以及所在单位
select distinct reader.r_name, reader.r_unit
from reader
         inner join borrow on reader.r_no = borrow.r_no;

-- 4、找出李某所借图书的所有图书的书名及借书日期
select distinct reader.r_name, book.b_name, borrow.b_time
from reader,
     borrow,
     book
where reader.r_name like '李%'
  and reader.r_no = borrow.r_no
  and book.b_no = borrow.b_no;

-- 5、查询2020-09-01以后借书的读者借书证号、姓名和单位
select reader.r_no, reader.r_name, reader.r_unit
from reader,
     borrow
where b_time > '2020-09-01'
  and reader.r_no = borrow.r_no;

-- 7、找出借阅了FoxPro大全一书的借书证号以及作者
select borrow.r_no, book.b_author
from book,
     borrow
where borrow.b_no = book.b_no
  and book.b_name = 'FoxPro大全';

-- 8、分别找出借书人次超过2人次的单位及人次数
select reader.r_unit, count(reader.r_no)
from reader,
     borrow
where reader.r_no = borrow.r_no
group by reader.r_unit
having count(reader.r_no) > 2;

-- 9、找出与赵正义在同一天借书的读者姓名、所在单位以及借书日期
select reader.r_name, reader.r_unit, borrow.b_time
from reader,
     borrow
where borrow.r_no = reader.r_no
  and borrow.b_time = (select borrow.b_time
                       from borrow,
                            reader
                       where reader.r_name = '赵正义'
                         and reader.r_no = borrow.r_no)
  and reader.r_name != '赵正义';

-- 10、求信息系当前借阅图书的读者人次数
select count(reader.r_no), reader.r_unit
from reader,
     borrow
where reader.r_no = borrow.r_no
  and reader.r_unit = '信息系';

-- 11、找出当前至少借阅了2本书的读者所在单位
select count(reader.r_no), reader.r_unit
from reader,
     borrow
where reader.r_no = borrow.r_no
group by reader.r_no
having count(reader.r_no) >= 2;

-- 12、找出姓李的读者姓名和所在单位
select r_name, r_unit
from reader
where r_name like '李%';

-- 13、求科学出版社图书的最高单价、最低单价和平均单价
select max(b_price), min(b_price), avg(b_price)
from book
where b_publish = '科学出版社';

-- 14、查找出高等教育出版社的所有图书及单价，结果按单价降序排列
select b_name, b_price
from book
where b_publish = '高等教育出版社'
group by b_price desc;

-- 15、列出图书库中所有藏书的书名以及出版单位
select b_name,b_publish from book;

