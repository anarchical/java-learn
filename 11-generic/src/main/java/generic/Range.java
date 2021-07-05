package generic;

/**
 * @author YeYaqiao
 * 泛型的上下限，限制泛型的范围
 */
public class Range {
    public static void main(String[] args) {

        Upper<Integer> integerUpper = new Upper<>();
        integerUpper.print(1);

        Lower<Object> objectLower = new
    }
}

/**
 * 泛型上限
 *
 * @param <T> 对象的类型只能是 Number 或其子类
 */
class Upper<T extends Number> {
    public void print(T integer) {
        System.out.println("泛型上限" + integer);
    }

    public void print(? extends Number ){

    }
}

/**
 * 泛型下限
 *
 * @param <T>
 */
class Lower<T super Number>{
public void print(T integer){
        System.out.println("泛型下限"+integer);
        }
        }