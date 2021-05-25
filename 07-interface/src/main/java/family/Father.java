package family;

/**
 * @author YeYaqiao
 */
public interface Father {

    //默认被 public static final 修饰
    String description = "father is rich";

    //默认被 public abstract 修饰
    void handsome();

    //默认方法可以有方法体
    default void rich() {
        System.out.println("father is rich");
    }
}
