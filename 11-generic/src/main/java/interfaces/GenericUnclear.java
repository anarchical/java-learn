package interfaces;

/**
 * @author YeYaqiao
 * 泛型接口实现
 * 没有明确具体的泛型参数类型
 */
public class GenericUnclear<T> implements Print<T> {

    @Override
    public void print(T info) {
        System.out.println(info);
    }

    public static void main(String[] args) {

        GenericUnclear<String> genericUnclear = new GenericUnclear<>();
        genericUnclear.print("未明确泛型所使用的类型");
    }
}
