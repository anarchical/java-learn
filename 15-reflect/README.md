### 反射

> RTTI（RunTime Type Information，运行时类型信息）能够在程序运行时发现和使用类型信息

RTTI 使我们在编译时就已经知道了所有类型信息

反射机制是 java 成为动态语言的关键，允许我们运行时发现和使用类的信息

#### Class 类

Class 类是用来专门描述其它类的一种类，在 java.lang 包中，其对象就是对其它类结构抽象的对象

```java
public class MyClass {
    public static void main(String[] args) throws ClassNotFoundException, IOException {

        Class<?> clazz = Class.forName("Dog");//通过全类名获取类型信息
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

同一个类的 Class 类对象只有一个，因为内存中每个运行时类只有一个，可以通过四种方法获取：

| 方法名                    | 作用                       |
| ------------------------- | -------------------------- |
| Class.forName(String className) | 通过全类名获取类型信息对象 |
| TargetObject.Class | 知道具体类的情况下 |
| new TargetObject.getClass() | 通过实例对象获取 |
| ClassLoader.loadClass(String className) | 通过类加载器获取获取 |

#### 代理模式

代理模式（Proxy Pattern）是一种 java 常见的设计模式，是桥接模式的一种特殊情况

##### 静态代理

代理类提前指定好

* 优点

  功能解耦，简单易用

* 缺点

  若委托类所需要的代理方式不够通用，则可能需要创建多个代理类；若接口发生变化，则代理类也需修改

```java
public class StaticProxy {
    public static void main(String[] args) {
        //创建委托对象
        Car carBenzFactory = new CarBenzFactory();
        Car carAudiFactory = new CarAudiFactory();

        //创建代理对象，通过代理，都新增了"讨好客户"的次要业务
        Car carProxy = new CarProxy(carBenzFactory);
        //调用代理模式的方法，执行代理类中的次要业务和委托类的主要业务
        carProxy.sellCar();

        //更换委托类
        carProxy = new CarProxy(carAudiFactory);
        carProxy.sellCar();
    }
}

//通过接口定义代理类和委托类的共同方法
interface Car {
    void sellCar();
}

//委托类
class CarAudiFactory implements Car {
    @Override
    public void sellCar() {
        System.out.println("卖奥迪汽车");
    }
}

//委托类
class CarBenzFactory implements Car {

    @Override
    public void sellCar() {
        System.out.println("卖奔驰汽车");
    }
}

//代理类
class CarProxy implements Car {

    private final Car car;

    //传入委托对象，获得委托类的主要业务
    public CarProxy(Car car) {
        this.car = car;
    }

    @Override
    public void sellCar() {
        //代理执行，次要业务
        System.out.println("启动代理模式，讨好客户");
        //代理执行，主要业务
        car.sellCar();
    }
}
```

##### 动态代理

代理类依据反射动态生成

* 优点

  动态生成代理类，降低了对业务接口的依赖，降低耦合度

* 缺点

  依然无法摆脱对接口的依赖

```java
public class DynamicProxy {
    public static void main(String[] args) {
        //创建委托对象
        Car carBenzFactory = new CarBenzFactory();
        Car carAudiFactory = new CarAudiFactory();

        //动态获取代理类对象，新增了"良心代理，讨好客户"的次要业务
        CarGoodProxyHandler carProxyHandler = new CarGoodProxyHandler(carBenzFactory);
        Car carProxy = (Car) Proxy.newProxyInstance(
                CarGoodProxyHandler.class.getClassLoader(),
                new Class[]{Car.class},
                carProxyHandler);
        //调用代理模式的方法，执行代理类中的次要业务和委托类的主要业务
        carProxy.sellCar();

        //动态获取代理类对象，新增了"黑心代理，讨好客户"的次要业务
        CarBadProxyHandler carBadProxyHandler = new CarBadProxyHandler(carAudiFactory);
        carProxy = (Car) Proxy.newProxyInstance(
                CarBadProxyHandler.class.getClassLoader(),
                new Class[]{Car.class},
                carBadProxyHandler);
        //调用代理模式的方法，执行代理类中的次要业务和委托类的主要业务
        carProxy.sellCar();
    }
}

//通过接口定义代理类和委托类的共同方法
interface Car {
    void sellCar();
}

//委托类
class CarAudiFactory implements Car {
    @Override
    public void sellCar() {
        System.out.println("卖奥迪汽车");
    }
}

//委托类
class CarBenzFactory implements Car {

    @Override
    public void sellCar() {
        System.out.println("卖奔驰汽车");
    }
}

//动态生成代理类
class CarGoodProxyHandler implements InvocationHandler {

    //委托对象
    private final Object object;

    //设置委托对象
    public CarGoodProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //新增次要业务
        System.out.println("良心代理，讨好客户");
        //执行委托类主要业务
        return method.invoke(this.object, args);
    }
}

class CarBadProxyHandler implements InvocationHandler {

    //委托对象
    private final Object object;

    //设置委托对象
    public CarBadProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //新增次要业务
        System.out.println("黑心代理，讨好客户");
        //执行委托类主要业务
        return method.invoke(this.object, args);
    }
}
```



 