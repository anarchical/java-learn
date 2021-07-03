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
dsa
