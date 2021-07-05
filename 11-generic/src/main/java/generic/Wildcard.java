package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeYaqiao
 * 泛型通配符
 * 不同类型的泛型引用不能直接传递(与多态有些许相似)
 */
public class Wildcard {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();

        wildcard(stringList);
        wildcard(integerList);

    }

    public static void wildcard(List<?> list) {
        System.out.println(list);
    }

    public static void wildcard(List list){
        System.out.println(list);
    }
}
