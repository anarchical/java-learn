### 继承

通过关键字 extends，让子类可以复用父类中的非私有属性和方法

> 事实证明，在创建类时总是要继承，因为除非显式地继承其他类，否则就隐式地继承 Java 的标准根类对象（Object）	--《On Java8》

#### 子类的创建

```java
public class Son extends Father {

    public static void main(String[] args) {
        Son son = new Son();
    }
}

class Father {
    public Father() {
        System.out.println("father");
    }
}
```

子类创建时会默认先调用父类的无参参构造方法初始化父类，若父类没有无参构造器，则必须使用 super 关键字调用父类的某个构造方法

* this关键字：this指向当前对象，this()表示当前对象的构造方法
* super关键字：super指向父类对象，super()表示父类对象的构造方法



#### 常见问题

1. 如何判断一个勒种有没有构造器？

   反射机制

   


