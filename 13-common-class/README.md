### 常用类

#### 字符串

String、StringBuilder、StringBuffer

##### String

> `String` 对象是不可变的。查看 JDK 文档你就会发现，`String` 类中每一个看起来会修改 `String` 值的方法，实际上都是创建了一个全新的 `String` 对象，以包含修改后的字符串内容。而最初的 `String` 对象则丝毫未动。-- OnJava8

对 String 的任何修改操作，都会生成新的对象

* 字符串的创建

  1. 直接创建`String str = "string"`：会先去方法区中的常量池寻找，若存在则直接引用这个常量的地址，若不存在则在常量池中创建后再引用
  2. 通过 new 关键字创建 `String str = new String("string")`：首先会在堆中开辟一个空间，str指向这个空间的内存地址，然后再去常量池中寻找，若存在则直接引用这个常量的地址，若不存在则在常量池中创建后再引用

* 字符串常量池

  String 是开发中常用的一种引用类型，多次创建新的字符串会消耗系统性能，相同的字符内容会浪费内存空间

  字符串常量池位于**方法区**中，当创建新的引用指向某个字符串时，会先该字符串是否存在常量池中，存在则将其引用直接返回，若不存在则在常量池中创建新的字符串后再返回其地址

* String 默认重写了 equals() 方法

  ```java
  public class MyString {
      public static void main(String[] args) {
          
          String a = new String("a");
          String b = new String("a");
  
          System.out.println(a == b);
          System.out.println(a.equals(b));
      }
  }
  ```

  默认情况下 equals() 方法和 == 一样，用于比较对象的地址信息是否相同；String 类默认重写了 equals() ，若地址不相同，则再比较是字符串的内容，

##### StringBuilder

StringBuilder 主要解决 String 创建后不可改变的问题，StringBuilder 类的对象可以被多次修改，并且不产生垃圾对象；是线程不安全的

StringBuilder 内部为一个可变 char 数组，初始容量为 16，当容量满时扩容成原理容量的2倍+2

##### StringBuffer

StringBuffer 与 StringBuilder 功能相似，主要区别为 StringBuffer 是线程安全的，效率不如 StringBuilder

#### 日期类

##### Date

不推荐使用 Date 的原因：可读性差、SimpleDateFormat() 线程不安全、时区转换较复杂

##### LocalDateTime

可读性好、线程安全、格式转换方便

* LocalDate

  只获取年月日

* LocalTime

  只获取时分秒

* LocalDateTime

  获取完整的时间信息

  ```java
  public class MyLocal {
      public static void main(String[] args) {
          LocalDate localDate = LocalDate.now();
          System.out.println(localDate);
  
          LocalTime localTime = LocalTime.now();
          System.out.println(localTime);
  
          LocalDateTime localDateTime = LocalDateTime.now();
          System.out.println(localDateTime);
  
          String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
          System.out.println(format);
          
      }
  }
  ```

* Instant

  获取当前秒数，作用相当于 `System.currentTimeMillis()`

  ```java
  public class MyInstant {
  
      public static void main(String[] args) {
          System.out.println(System.currentTimeMillis());
  
          Instant instant=Instant.now();
          System.out.println(instant.getEpochSecond());
          System.out.println(instant.toEpochMilli());
      }
  }
  ```

#### Math

```java
public class MyMath {

    public static void main(String[] args) {
        //自然对数的底数
        System.out.println(Math.E);
        //圆周率
        System.out.println(Math.PI);
        //9 的开平方
        System.out.println(Math.sqrt(9));
        //8的开立方
        System.out.println(Math.cbrt(8));
        //2的3次方
        System.out.println(Math.pow(2, 3));
        //两数最大
        System.out.println(Math.max(1, 9));
        //两数最小
        System.out.println(Math.min(1, 9));
        //求绝对值
        System.out.println(Math.abs(-10));
        //向下取整
        System.out.println(Math.floor(10.999));
        //向上取整
        System.out.println(Math.ceil(10.001));
        //四舍五入
        System.out.println(Math.round(5.60));
        //取随机数
        System.out.println(Math.random());
        //高精度小数
        System.out.println(new BigDecimal("0.1"));
    }
}
```



#### 常见问题

