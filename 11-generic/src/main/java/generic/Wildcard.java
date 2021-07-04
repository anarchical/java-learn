package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeYaqiao
 * 泛型通配符
 * 解决泛型标识符没有多态的问题
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

//    public static void wildcard(List list){
//        System.out.println(list);
//    }
}
