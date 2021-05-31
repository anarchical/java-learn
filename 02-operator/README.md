[TOC]

### 运算符

#### 位运算符（按位运算符）

> 位运算符允许我们操作一个整型数字中的单个二进制位。位运算符会对两个整数对应的位执行布尔代数，从而产生结果。 -- On Java8

1. `&` 与运算

   若两个输入位都是1，则结果为1，否则结果为0

   ```java
   System.out.println(1 & 1);//1
   System.out.println(1 & 0);//0
   System.out.println(0 & 0);//0
   ```

2. `|`或运算

   若两个输入位都是0，则结果为0，否则结果为1

   ```java
   System.out.println(1 | 1);//1
   System.out.println(1 | 0);//1
   System.out.println(0 | 0);//0
   ```

3. `^`异或运算

   若两个输入位不一样（一个是1，一个是0），则结果为1；若输入位一样，则结果为0

   ```java
   System.out.println(1 ^ 1);//0
   System.out.println(1 ^ 0);//1
   System.out.println(0 ^ 0);//0
   ```

4. `~`非运算（一元运算符）

   它只对一个自变量进行操作（其他所有运算符都是二元运算符）。按位非运算后结果与输入位相反。例如输入 0，则输出 1；输入 1，则输出 0。

   ```java
   System.out.println(~1);-2
   System.out.println(~0);-1
   ```

#### 移位运算符

> 移位运算符面向的运算对象也是二进制的“位”。它们只能用于处理整数类型（基本类型的一种）。 -- OnJava8

1. `<<` 左移运算符

   左移位运算符 `<<` 能将其左边的运算对象向左移动右侧指定的位数（在低位补 0）

   num << n，相当于 num * 2^n

   ```java
   num = 4;
   System.out.println(num << 1);
   num = -4;
   System.out.println(num << 1);
   
   //8
   //-8
   ```

2. `>>`右移运算符

   右移位运算符 `>>` 能将其左边的运算对象向右移动右侧指定的位数；若值为正，则在高位插入0；若值为负，在高位插入1

   num >> n，相当于 num / 2^n

   ```java
   num = 16;
   System.out.println(num >> 1);
   num = -16;
   System.out.println(num >> 1);
   
   //8
   //-8
   ```

3. `>>>` 无符号右移

   `>>>`在右移运算规则的基础上，取消判断正负值，高位始终插入0

   ```java
   num = 16;
   System.out.println(num >>> 1);
   num = -16;
   System.out.println(num >>> 1);
   
   //8
   //2147483640
   ```

   

   