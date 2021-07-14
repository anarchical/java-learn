package dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @author YeYaqiao
 */
public class Main {
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
