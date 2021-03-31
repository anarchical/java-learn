package abstractExp;

/**
 * @author YeYaqiao
 */
public class Cat extends Animal {

    //继承抽象类后必须实现里面的抽象方法，否则编译器会报错
    @Override
    public void eat() {
        System.out.println("猫猫吃饭");
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.eat();
        cat.sleep();
    }
}
