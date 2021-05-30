/**
 * @author YeYaqiao
 * 按位运算符 与或非异或
 */
public class BitOperation {

    public static void main(String[] args) {

        System.out.println(1 & 1);
        System.out.println(1 & 0);
        System.out.println(0 & 0);

        System.out.println(1 | 1);
        System.out.println(1 | 0);
        System.out.println(0 | 0);

        System.out.println(1 ^ 1);
        System.out.println(1 ^ 0);
        System.out.println(0 ^ 0);

        System.out.println(~1);
        System.out.println(~0);
    }
}
