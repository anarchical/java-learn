### 接口

接口是由抽象类衍生出来的一个概念

面向接口编程就是将程序的业务逻辑进行分离，以接口的形式去对接不同的业务模块，以实现解耦的目的

接口只负责规定内容不负责实现，具体的实现由实现接口的实现类完成

优点：

1. 低耦合、高内聚
2. 利于程序的扩展（通过继承）;对于接口之间可以多继承（方便接口功能的扩展），同时一个实现类可以实现多个接口
3. 有利于后期维护

#### 接口的定义

JDK1.8之前接口中不允许有非抽象方法

JDK1.8之后接口中可以定义默认方法，使用default关键字修饰

```java
public interface Father {

    //默认被 public static final 修饰
    String description = "father is rich";

    //默认被 public abstract 修饰
    void handsome();

    //默认方法可以有方法体
    default void rich() {
        System.out.println("father is rich");
    }
}

public interface Mother {

    String description = "mather is rich";

    void beauty();

    default void rich() {
        System.out.println(description);
    }
}
```

接口中定义成员变量和成员方法的要求：

1. 不能定义 private 和 protected 修饰的成员变量和成员方法，只能定义 public（可以不声明） 访问权限的成员变量和方法（因为接口是被实现的，而不是被继承的，所以 protected 关键字不适用）
2. 接口中定义的成员变量默认被`public static final`修饰（静态常量），因此定义时必须被初始（因为接口无法实例化，所以只能定义类变量）

#### 接口的实现

使用 implements 关键字实现接口

```java
public class Son implements Father, Mother {

    @Override
    public void handsome() {
        System.out.println("实现了爸爸的帅");
    }

    @Override
    public void beauty() {
        System.out.println("实现了妈妈的美");
    }

    @Override
    public void rich() {
        Father.super.rich();
        Mother.super.rich();
    }

    public static void main(String[] args) {
      
        Son son = new Son();
        son.rich();
    }
}
```

#### 常见问题

1. 接口中只能有抽象方法吗？

   JDK1.8之前，接口中只能定义抽象方法

   JDK1.8之后，接口中可以定义默认方法（有方法实现），使用 default 关键字修饰

   

