package erasure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeYaqiao
 * 泛型擦除
 */
public class Erasure {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();

        stringList.add("123");
        integerList.add(1);

        System.out.println(stringList.getClass() == integerList.getClass());
    }
}
