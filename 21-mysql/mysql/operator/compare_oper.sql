-- 0 表示 false，1 表示 true
-- 等于 = （有一边为则结果为 NULL ）
select 1 = 2;
-- 不等于 <>, !=
select 1 <> 2;
select 1 != 2;
-- 安全等于 <=> （当两边为 NULL 时，结果为 1，有一边为 NULL 时，结果为 0）
select null <=> null;
-- 小于 <
select 1 < 2;
-- 小于等于 <=
select 1 <= 2;
-- 大于 >
select 1 > 2;
-- 大于等于 >=
select 1 >= 2;
-- 在两值之间 between
select 3 between 1 and 5;
-- 不在两值之间 not between
select 3 not between 1 and 5;
-- 在集合中 in
select 5 in (1, 2, 3, 4, 5, 6);
-- 不在集合中 not in
select 5 not in (1, 2, 3, 4, 5, 6);
-- 模糊匹配 like
select 'mysql' like '%sql';
-- 正则匹配 regexp, rlike
select 'mysql' regexp 'sql';
-- 为空 is null
select null is null;
-- 不为空 is not null
select null is not null;