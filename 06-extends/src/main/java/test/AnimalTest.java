package test;

class Animal {

    public void speak() {
        System.out.println("说话");
    }

    public void eat() {
        System.out.println("吃饭");
    }

    public void sleep() {
        System.out.println("睡觉");
    }
}

class Cat extends Animal {

    @Override
    public void speak() {
        System.out.println("猫叫");
    }

    @Override
    public void eat() {
        System.out.println("猫吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("猫睡觉");
    }
}

class Dog extends Animal {

    @Override
    public void speak() {
        System.out.println("狗叫");
    }

    @Override
    public void eat() {
        System.out.println("狗吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("狗睡觉");
    }
}

public class AnimalTest {

    public static void main(String[] args) {

        Animal cat = new Cat();
        cat.speak();
        cat.eat();
        cat.sleep();

        Animal dog = new Dog();
        dog.speak();
        dog.eat();
        dog.sleep();
    }
}
