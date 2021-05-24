package abstractExp;

/**
 * @author YeYaqiao
 * 一个类如果有一个或多个抽象方法，那它必须是抽象类
 * 抽象类里面可以没有抽象方法
 */
abstract class Animal {

    public static int age;

    public Animal(int age) {
        System.out.println("这是一种动物");
    }

    //抽象方法
    public abstract void eat();

    //普通方法
    public void sleep() {
        System.out.println("动物睡觉差不多都一样");
    }
}

class Cat extends Animal {

    public Cat(int age) {
        super(age);
    }

    //继承抽象类后必须实现里面的抽象方法，否则编译器会报错
    @Override
    public void eat() {
        System.out.println("猫猫吃饭");
    }
}

public class AnimalTest {
    public static void main(String[] args) {
        Animal cat = new Cat(2);
        cat.eat();
        cat.sleep();

        Animal dog = new Animal(3) {
            @Override
            public void eat() {
                System.out.println("狗狗吃饭");
            }
        };
        dog.eat();
        dog.sleep();
    }
}