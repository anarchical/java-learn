package map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author YeYaqiao
 */
public class MyLinkedHashMap {
    public static void main(String[] args) {
        Map<String,String> map=new LinkedHashMap<>();

        map.put(null,null);
        System.out.println(map);
    }
}
