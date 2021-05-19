package example;

/**
 * @author YeYaqiao
 */
public class Son extends Father {

    public Son() {
        System.out.println("example.Son init");
    }

    public void sonMethod() {
        System.out.println("sonMethod");
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.grandpaMethod();
        son.fatherMethod();
        son.sonMethod();
    }
}
