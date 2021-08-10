-- 字符串 s2 替换 s1 的 x 位置开始长度为 len 的字符串（以1位开头，而不是0）
select insert('hello world', 7, 5, 'mysql');
-- 将字母转为大写
select upper('string');
-- 将字母转为小写
select lower('STRING');
-- 获取字符串 s 前 len 个字符
select left('hello world', 5);
-- 获取字符串 s 后 len 个字符
select right('hello world', 5);
-- 从 index 开始截取 len 个字符
select substring('hello world', 5, 3);
-- 获取字符串的逆序
select reverse('hello world');