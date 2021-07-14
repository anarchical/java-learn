package staticProxy;

/**
 * @author YeYaqiao
 * 委托类
 */
public class CarAudiFactory implements Car {
    @Override
    public void sellCar() {
        System.out.println("卖奥迪汽车");
    }
}
