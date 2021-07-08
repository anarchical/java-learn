### 常用类

#### 字符串

String、StringBuilder、StringBuffer

##### String

> `String` 对象是不可变的。查看 JDK 文档你就会发现，`String` 类中每一个看起来会修改 `String` 值的方法，实际上都是创建了一个全新的 `String` 对象，以包含修改后的字符串内容。而最初的 `String` 对象则丝毫未动。-- OnJava8

* 字符串常量池

  ```java
  
  ```

  

* String 重写了 equals() 方法

  ```java
  
  ```

  

##### StringBuilder

##### StringBuffer

#### 日期类

##### Date

##### LocalDateTime

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



