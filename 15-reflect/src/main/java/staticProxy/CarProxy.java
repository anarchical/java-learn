package staticProxy;

/**
 * @author YeYaqiao
 * 代理类
 */
//@SuppressWarnings("all")
public class CarProxy implements Car {

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
