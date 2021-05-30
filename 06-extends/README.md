### 继承

通过关键字 extends，让子类可以复用父类中的非私有属性和方法

> 事实证明，在创建类时总是要继承，因为除非显式地继承其他类，否则就隐式地继承 Java 的标准根类对象（Object）	-- On Java8

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

#### 多态

一个对象在不同情况下有多种不同的表现形式，在代码中的具体表现为父类的引用指向子类的对象（向上转型）

#### 抽象类

实现多态时，子类一般继承的为抽象类；因为父类中的方法会被子类重写，所以父类中没有实现方法的必要，只需要规定方法的方法签名和访问范围

有抽象方法的类肯定是抽象类（抽象类中可以没有抽象方法，但是没必要，失去了抽象类的意义）;抽象类可以拥有普通类所能拥有的内容（构造方法、变量等），但是普通类肯定不能有抽象方法

抽象类只能被继承，不能被直接初始化和调用

1. 抽象类的定义

   ```java
   abstract class Animal {
   
       public static int age;
   
       public Animal(int age) {
           System.out.println("这是一种动物");
       }
   
       //抽象方法
       public abstract void eat();
   
       //普通方法
       public void sleep() {
           System.out.println("动物睡觉差不多都一样");
       }
   }
   ```

2. 抽象类的使用（创建子类）

   ```java
   class Cat extends Animal {
   
       public Cat(int age) {
           super(age);
       }
   
       //继承抽象类后必须实现里面的抽象方法，否则编译器会报错
       @Override
       public void eat() {
           System.out.println("猫猫吃饭");
       }
   }
   
   public class AnimalTest {
       public static void main(String[] args) {
           Animal cat = new Cat(2); //父类的引用指向子类的对象
           cat.eat();
           cat.sleep();
       }
   }
   ```


3. 使用匿名内部类实现多态（不需要创建子类）

   ```java
   //创建匿名内部类
   Animal dog = new Animal(3) {
     @Override
     public void eat() {
       System.out.println("狗狗吃饭");
     }
   };
   dog.eat();
   dog.sleep();
   ```



#### 常见问题

1. 如何判断一个类有没有构造器？

   反射机制

2. 什么是 Object 类？

   Object 是 JDK 提供的一个类，是所有类的根节点，JDK 中其它的类、开发者自定义的类和第三方库中的类都是 Object 的派生类

3. 讲一下 Object 的 hashCode() 和 equals() ？

   1. hashCode(): JVM 内存中将对象存到一个哈希列表，并返回一个数字类型的映射值（利用散列算法将内存地址和对象的内部信息融合成一个值），就是该对象的 hashCode，可以用来判断两个对象是否相等（若 hashCode 不相等，则两个对象肯定不一样，但是如果 hashCode 相等，两个对象不一定相等）
   2. equals(): equals() 在不重写的情况写，使用 == 进行比较（== 作用于栈内存，可以比较内存地址和基本数据类型）

4. 为什么 HashSet 判断对象是否相等时不直接使用 equals() ？

   先使用 hashCode() 判断效率会更高，若两个对象 hashCode() 一样，则会再使用 equals() 判断两个对象内存地址




