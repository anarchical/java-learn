package string;

/**
 * @author YeYaqiao
 * 字符串
 */
public class MyString {
    public static void main(String[] args) {


        String a = new String("a");
        String b = new String("a");
        String c = "a";
        String d = "a";

        System.out.println(a == b);
        System.out.println(a.equals(b));

        System.out.println(a == c || b == c);
        System.out.println(c == d);
    }
}
