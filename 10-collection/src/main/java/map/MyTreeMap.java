package map;

import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author YeYaqiao
 */
public class MyTreeMap {

    public static void main(String[] args) {
        Map<String,String> map=new TreeMap<>();

        map.put("null",null);
        System.out.println(map);
    }
}
