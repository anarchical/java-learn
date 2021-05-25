package interfaceExp;

/**
 * @author YeYaqiao
 * java8 之后可以在接口中新增 属性、默认方法和静态方法
 * 属性默认都被 public static final 修饰的，且不可更改
 * 接口中的方法默认都是 public 的，且不可更改
 */
public interface MyInterface {

    String s = "接口的静态方法";

    //抽象方法
    void abstractMethod();

    //默认方法，可以有方法实现
    default void defaultMethod() {
        System.out.println("接口的默认方法");
        System.out.println(staticMethod());

    }

    //静态方法，可以有方法实现
    static String staticMethod() {
        return s;
    }
}
