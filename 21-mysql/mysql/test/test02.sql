# 本题用到下面三个关系表：
# 借书卡表：卡号 、姓名 、班级
# 图书表：书号、书名、作者、单价、库存册数
# 借书记录表： 借书卡号、 书号、 还书日期
# 以上表对应的字段明细如下：
# card  （  CNO  ， NAME ， CLASS  ）
# books （ BNO ，BNAME ,  AUTHOR ，PRICE ，QUANTITY  ）
# borrows  （ CNO ，BNO ，RDATE ）
# 备注：限定每人每种书只能借一本；库存册数随借书、还书而改变。
# 要求实现如下10个功能：
#

-- 1、找出借书超过5本的读者,输出借书卡号及所借图书册数。
select CNO, count(CNO)
from borrows
group by CNO
having count(CNO) > 5;

# 2、查询借阅了"水浒"一书的读者，输出姓名及班级。
select NAME, CLASS
from card,
     borrows,
     books
where card.CNO = borrows.CNO
  and books.BNO = borrows.BNO
  and BNAME = '水浒';

# 3、查询过期未还图书，输出借阅者（卡号）、书号及还书日期。
select CNO, BNO, RDATE
from borrows
where RDATE < curdate();

# 4、查询书名包括"网络"关键词的图书，输出书号、书名、作者。
select BNO, BNAME, AUTHOR
from books
where BNAME like '%网络%';

# 5、查询现有图书中价格最高的图书，输出书名及作者。
select BNAME, AUTHOR
from books
where PRICE = (select max(PRICE) from books);

# 6、查询当前借了"计算方法"但没有借"计算方法习题集"的读者，输出其借书卡号，并按卡号降序排序输出。
select br.CNO, BNAME
from card c,
     borrows br,
     books b
where c.CNO = br.CNO
  and b.BNO = br.BNO
  and BNAME = '计算方法'
  and br.CNO not in (select c.CNO
                     from books b,
                          borrows br,
                          card c
                     where b.BNO = br.BNO
                       and c.CNO = br.CNO
                       and BNAME = '计算方法习题集')
order by c.CNO desc;

# 7、将"C01"班同学所借图书的还期都延长一周。
update borrows,card
set RDATE=adddate(RDATE, 7)
where borrows.CNO = card.CNO
  and CLASS = 'c01';

# 8、从BOOKS表中删除当前无人借阅的图书记录。
delete
from books
where BNO not in (select BNO from borrows);

# 9、查询当前同时借有"计算方法"和"组合数学"两本书的读者，输出其借书卡号，并按卡号升序排序输出。
select card.CNO
from books,
     borrows,
     card
where books.BNO = borrows.BNO
  and card.CNO = borrows.CNO
  and BNAME = '计算方法'
  and borrows.CNO in (select br.CNO
                      from borrows br,
                           books b
                      where br.BNO = b.BNO
                        and b.BNAME = '组合数学'
)
order by card.CNO;

