package test;

public class Son extends Father {

    public Son(String id) {
        super(id);
    }

    public static void main(String[] args) {
        Son son = new Son("son");
    }
}

class Father {
    public Father(String id) {
//        System.out.println("father");
    }
}
