package dynamicProxy;

/**
 * @author YeYaqiao
 * 委托类
 */
public class CarBenzFactory implements Car {

    @Override
    public void sellCar() {
        System.out.println("卖奔驰汽车");
    }
}
