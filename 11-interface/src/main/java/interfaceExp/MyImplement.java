package interfaceExp;

/**
 * @author YeYaqiao
 */
public class MyImplement implements MyInterface {


    @Override
    public void abstractMethod() {
        System.out.println("实现了抽象方法");
    }


    public static void main(String[] args) {
        MyInterface myInterface = new MyImplement();
        myInterface.abstractMethod();
        myInterface.defaultMethod();

        System.out.println(MyInterface.staticMethod());
    }

}
