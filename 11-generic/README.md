[toc]

### 泛型

generics 是指在定义类的时候不指定类中的某个信息（属性、方法返回值）的具体数据类型，而是用一个标识符来替代，称为**类型参数变量**，当外部实例化对象时通过指定**实际类型参数**确定具体的数据类型（只能是引用类型）

使用泛型可以保证数据的统一性，又能兼具灵活性，避免强制类型转换导致的操作不安全

通过占位符 `<E>` 来替代具体的数据类型；一旦创建对象确认好数据类型，其相关的数据类型只能是本类或是其子类（多态）

占位符内容可是随意填写，但是一般使用 K、V、T、E 来表示（key、value、type、element）具体的意思

`<>` 中可以填写多个标识符，以 `,` 分隔；如 HashMap(K, V)

#### 泛型的使用
##### 泛型类

泛型类就是把泛型定义在类上，用户使用该类的时候，才把类型明确下来

在类上定义的泛型，在方法中也可以使用

```java
public class GenericClass<E> {

    private E name;

    public GenericClass() {
    }

    public GenericClass(E name) {
        this.name = name;
    }

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }

    public static void main(String[] args) {

        GenericClass<String> genericClass = new GenericClass<>("generic");
        System.out.println(genericClass.getName());

        GenericClass<Integer> num = new GenericClass<>();
        num.setName(100);
        System.out.println(num.getName());

    }
}
```

##### 泛型方法

若仅仅只需要类中的某个方法支持泛型，则可以将泛型单独定义在某个方法上，而无需定义在类上

```java
public class GenericMethod {

    public <T> void print(T info){
        System.out.println(info);
    }

    public static void main(String[] args) {
        GenericMethod genericMethod=new GenericMethod();
        genericMethod.print("泛型方法");
    }
}
```



#### 泛型通配符

泛型的通配符解决的是**不同类型的泛型引用不能直接传递**的问题（也可以通过不使用泛型来解决，但是编译器会有告警提示）

泛型通配符 <?> 通配符只能作为引用参数使用，不能用来修饰类或者方法

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
}
```

#### 泛型的上限和下限

对泛型使用的数据类型的进行扩充或限制

* 泛型的上限

  使用 extends 关键字，限制使用类型的上限类型

  `类名 <泛型标识符 extends 上限类名>`

  可以用来修饰类、方法、以及方法参数

  ```java
  public class Upper<T extends Number> {
  
      public void print(T integer) {
          System.out.println("只能传入数字类型：" + integer);
      }
  
      //在方法参数中定义泛型上限
      public void print(List<? extends Number> list) {
          System.out.println(list);
      }
  
      public <E extends Number> void printNumber(E info) {
          System.out.println(info);
      }
  
      public static void main(String[] args) {
  
          Upper<Integer> integerUpper = new Upper<>();
          integerUpper.print(1);
          integerUpper.printNumber(1);
  
          List<Double> list = new ArrayList<>();
          list.add(1.23);
          integerUpper.print(list);
      }
  }
  ```

* 泛型的下限

  使用 super 关键字，限制使用类型的下限类型

  `类名 <泛型标识符 super 下限类名>`

  只能用来修饰方法参数

  ```java
  public class Lower {
  
      public void print(List<? super String> list) {
          System.out.println("泛型下限" + list);
      }
  
      public static void main(String[] args) {
          
          Lower lower=new Lower();
          
          List<String> stringList=new ArrayList<>();
          lower.print(stringList);
          
          List<Object> objectList=new ArrayList<>();
          lower.print(objectList);
      }
  }
  ```


注意：

1. 泛型的上限可以用来修饰类、方法和方法参数；而泛型的下限只能修饰方法的参数

2. 泛型的上下限使用遵循 PECS 原则

   从集合中读取 T 类型的数据时，并且不能写入，则使用 <? extends 类名>（Producer Extends）

   从集合中写入 T 类型的数据时，并且不能读取，则使用 <? Super 类名>（Consumer Super）

   如果既要存又要取，那么就不要使用任何通配符

#### 泛型接口

##### 定义泛型接口

```java
public interface Print<T> {
    void print(T info);
}
```

##### 实现类确定参数类型变量

```java
public class GenericClear implements Print<String> {

    @Override
    public void print(String info) {
        System.out.println(info);
    }

    public static void main(String[] args) {

        GenericUnclear<String> genericUnclear = new GenericUnclear<>();
        genericUnclear.print("明确泛型所使用的类型");
    }
}
```

##### 实现类不确定参数类型变量

```java
public class GenericUnclear<T> implements Print<T> {

    @Override
    public void print(T info) {
        System.out.println(info);
    }

    public static void main(String[] args) {

        GenericUnclear<String> genericUnclear=new GenericUnclear<>();
        genericUnclear.print("未明确泛型所使用的类型");
    }
}
```

#### 泛型擦除

泛型的本质是参数化类型

泛型是**提供给javac编译器使用的**，它用于限定集合的输入类型，让编译器在源代码级别上，即挡住向集合中插入非法数据

但编译器编译完带有泛形的java程序后，**生成的class文件中将不再带有泛形信息**，这个过程称之为“擦除”，目的是避免过多的创建类而造成的运行时的过度消耗

擦出规则：

* 若泛型类型没有指定具体类型，用 Object 作为原始类型；
* 若有限定类型 < T exnteds XClass >，使用 XClass 作为原始类型；
* 若有多个限定 < T exnteds XClass1 & XClass2 >，使用第一个边界类型 XClass1 作为原始类型；

以下程序的运行结果始终是 true，因为本质都是 ArrayList

```java
public class Erasure {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();

        stringList.add("123");
        integerList.add(1);

        System.out.println(stringList.getClass() == integerList.getClass());
    }
}
```


