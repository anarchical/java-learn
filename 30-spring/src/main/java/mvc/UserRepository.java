package mvc;

import java.util.HashMap;

/**
 * @author YeYaqiao
 */
public class UserRepository {

    private static final HashMap<Integer, String> map = new HashMap<>();

    static {
        map.put(1, "张三");
    }

    public String getNameById(int id) {
        return map.get(id);
    }
}
