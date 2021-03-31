package abstractExp;

/**
 * @author YeYaqiao
 * 一个类如果有一个或多个抽象方法，那它必须是抽象类
 * 抽象类里面可以没有抽象方法
 */
public abstract class Animal {

    //抽象方法
    public abstract void eat();

    //普通方法
    public void sleep() {
        System.out.println("动物睡觉差不多都一样");
    }

}
