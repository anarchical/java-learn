[toc]

### 泛型

generics 是指在定义类的时候不指定类中的某个信息（属性、方法返回值）的具体数据类型，而是用一个标识符来替代，当外部实例化对象时再指定具体的数据类型

使用泛型可以保证数据的统一性，又能兼具灵活性

```java
public class MyGeneric<E> {

    private final E name;

    public MyGeneric(E name) {
        this.name = name;
    }

    public E getName() {
        return name;
    }

    public static void main(String[] args) {

        MyGeneric<String> myGeneric = new MyGeneric<>("generic");
        System.out.println(myGeneric.getName());

        MyGeneric<Integer> num=new MyGeneric<>(100);
        System.out.println(num.getName());
    }
}
```

通过占位符 `<E>` 来替代具体的数据类型；一旦创建对象确认好数据类型，其相关的数据类型只能是本类或是其子类

占位符内容可是随意填写，但是一般使用 K、V、T、E 来表示（key、value、type、element）

#### 泛型通配符

泛型的通配符解决的是**泛型标识符没有多态**的问题

```java
public class Wildcard {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();

        wildcard(stringList);
        wildcard(integerList);

    }

    public static void wildcard(List<?> list) {
        System.out.println(list);
    }

//    public static void wildcard(List list){
//        System.out.println(list);
//    }
}
```

#### 泛型的上限和下限

对规定使用的数据类型的扩充

* 泛型的上限

  使用 extends 关键字，限制使用类型的上限类型

  `类名 <泛型标识符 extends 上限类名>`

  ```java
  
  ```

* 泛型的下限

  使用 super 关键字，限制使用类型的下限类型

  `类名 <泛型标识符 super 下限类名>`

  ```java
  
  ```

  

#### 泛型接口



