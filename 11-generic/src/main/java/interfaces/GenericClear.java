package interfaces;

/**
 * @author YeYaqiao
 * 泛型接口实现
 * 明确具体的泛型参数类型
 */
public class GenericClear implements Print<String> {

    @Override
    public void print(String info) {
        System.out.println(info);
    }

    public static void main(String[] args) {

        GenericUnclear<String> genericUnclear = new GenericUnclear<>();
        genericUnclear.print("明确泛型所使用的类型");
    }
}

