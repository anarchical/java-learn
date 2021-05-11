package test;

/**
 * 求出100以内所有能被9整除的数之和
 *
 * @author YeYaqiao
 */
public class Sum {

    public static void main(String[] args) {

        int a = 1;
        int sum = 0;

        while (a * 9 < 100) {
            sum += a * 9;
            a++;
        }
        System.out.printf("100以内所有能被9整除的数之和为：%d", sum);

    }

}
