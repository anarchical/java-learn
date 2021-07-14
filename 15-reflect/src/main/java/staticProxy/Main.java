package staticProxy;

/**
 * @author YeYaqiao
 */
public class Main {
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
