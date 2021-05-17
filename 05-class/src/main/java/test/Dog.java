package test;

public class Dog {
    String name;
    String master;

    public void info(){
        System.out.println(name+"'s master is "+master);
    }
}

class TestDog{

    public static void main(String[] args) {
        Dog dog=new Dog();

        dog.name="汪汪";
        dog.master="老王";
        dog.info();
    }
}
