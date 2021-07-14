//package staticProxy;
//
///**
// * @author YeYaqiao
// */
//public class StaticProxy {
//    public static void main(String[] args) {
//        //创建委托对象
//        Car carBenzFactory = new CarBenzFactory();
//        Car carAudiFactory = new CarAudiFactory();
//
//        //创建代理对象，通过代理，都新增了"讨好客户"的次要业务
//        Car carProxy = new CarProxy(carBenzFactory);
//        //调用代理模式的方法，执行代理类中的次要业务和委托类的主要业务
//        carProxy.sellCar();
//
//        //更换委托类
//        carProxy = new CarProxy(carAudiFactory);
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
////代理类
//class CarProxy implements Car {
//
//    private final Car car;
//
//    //传入委托对象，获得委托类的主要业务
//    public CarProxy(Car car) {
//        this.car = car;
//    }
//
//    @Override
//    public void sellCar() {
//        //代理执行，次要业务
//        System.out.println("启动代理模式，讨好客户");
//        //代理执行，主要业务
//        car.sellCar();
//    }
//}