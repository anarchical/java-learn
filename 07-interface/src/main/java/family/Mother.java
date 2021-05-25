package family;

/**
 * @author YeYaqiao
 */
public interface Mother {

    String description = "mather is rich";

    void beauty();

    default void rich() {
        System.out.println(description);
    }
}
