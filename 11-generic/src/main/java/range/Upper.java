package range;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <T> 对象的类型只能是 Number 或其子类
 * @author YeYaqiao
 * 泛型上限
 * 实例化对象时只能选用指定的类型或是其子类
 * 可以用来修饰类和方法参数
 */
public class Upper<T extends Number> {

    public void print(T integer) {
        System.out.println("只能传入数字类型：" + integer);
    }

    //在方法参数中定义泛型上限
    public void print(List<? extends Number> list) {
        System.out.println(list);
    }

    public <E extends Number> void printNumber(E info) {
        System.out.println(info);
    }

    public static void main(String[] args) {

        Upper<Integer> integerUpper = new Upper<>();
        integerUpper.print(1);
        integerUpper.printNumber(1);

        List<Double> list = new ArrayList<>();
        list.add(1.23);
        integerUpper.print(list);
    }
}