### 反射

> RTTI（RunTime Type Information，运行时类型信息）能够在程序运行时发现和使用类型信息

RTTI 使我们在编译时就已经知道了所有类型信息

反射机制是 java 成为动态语言的关键，允许我们运行时发现和使用类的信息

#### Class 类

Class 类是用来专门描述其它类的一种类，在 java.lang 包中，其对象就是对其它类结构抽象的对象

```java
public class MyClass {
    public static void main(String[] args) throws ClassNotFoundException, IOException {

        Class<?> clazz = Class.forName(bean);//通过全类名获取类型信息
        Class<Dog> clazz1 = Dog.class;//通过字面量获取类型信息
        Class<? extends Dog> clazz2 = dog.getClass();//通过对象获取类型信息

        System.out.println(clazz);
        System.out.println(clazz1);
        System.out.println(clazz2);
        //同一个类所获取的类型信息对象都是相同的
    }
}

class Dog {
  
    String name;

    public String getName() {
        return name;
    }
}
```

同一个类的 Class 类对象只有一个，因为内存中每个运行时类只有一个，其常用方法有：

| 方法名                    | 作用                       |
| ------------------------- | -------------------------- |
| forName(String className) | 通过全类名获取类型信息对象 |
|                           |                            |
|                           |                            |

