package test;

/**
 * 使用循环打印出九九乘法表
 *
 * @author YeYaqiao
 */
public class MultiplicationTables {

    public static void main(String[] args) {

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%dx%d=%d ", i, j, i * j);
            }
            System.out.println();
        }
    }
}
