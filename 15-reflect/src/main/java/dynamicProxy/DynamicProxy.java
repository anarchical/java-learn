//package dynamicProxy;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//
///**
// * @author YeYaqiao
// */
//public class DynamicProxy {
//    public static void main(String[] args) {
//        //创建委托对象
//        Car carBenzFactory = new CarBenzFactory();
//        Car carAudiFactory = new CarAudiFactory();
//
//        //动态获取代理类对象，新增了"良心代理，讨好客户"的次要业务
//        CarGoodProxyHandler carProxyHandler = new CarGoodProxyHandler(carBenzFactory);
//        Car carProxy = (Car) Proxy.newProxyInstance(
//                CarGoodProxyHandler.class.getClassLoader(),
//                new Class[]{Car.class},
//                carProxyHandler);
//        //调用代理模式的方法，执行代理类中的次要业务和委托类的主要业务
//        carProxy.sellCar();
//
//        //动态获取代理类对象，新增了"黑心代理，讨好客户"的次要业务
//        CarBadProxyHandler carBadProxyHandler = new CarBadProxyHandler(carAudiFactory);
//        carProxy = (Car) Proxy.newProxyInstance(
//                CarBadProxyHandler.class.getClassLoader(),
//                new Class[]{Car.class},
//                carBadProxyHandler);
//        //调用代理模式的方法，执行代理类中的次要业务和委托类的主要业务
//        carProxy.sellCar();
//    }
//}
//
////通过接口定义代理类和委托类的共同方法
//interface Car {
//    void sellCar();
//}
//
////委托类
//class CarAudiFactory implements Car {
//    @Override
//    public void sellCar() {
//        System.out.println("卖奥迪汽车");
//    }
//}
//
////委托类
//class CarBenzFactory implements Car {
//
//    @Override
//    public void sellCar() {
//        System.out.println("卖奔驰汽车");
//    }
//}
//
////动态生成代理类
//class CarGoodProxyHandler implements InvocationHandler {
//
//    //委托对象
//    private final Object object;
//
//    //设置委托对象
//    public CarGoodProxyHandler(Object object) {
//        this.object = object;
//    }
//
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        //新增次要业务
//        System.out.println("良心代理，讨好客户");
//        //执行委托类主要业务
//        return method.invoke(this.object, args);
//    }
//}
//
//class CarBadProxyHandler implements InvocationHandler {
//
//    //委托对象
//    private final Object object;
//
//    //设置委托对象
//    public CarBadProxyHandler(Object object) {
//        this.object = object;
//    }
//
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        //新增次要业务
//        System.out.println("黑心代理，讨好客户");
//        //执行委托类主要业务
//        return method.invoke(this.object, args);
//    }
//}
//
