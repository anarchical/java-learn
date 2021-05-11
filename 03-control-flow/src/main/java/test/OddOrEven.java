package test;

import java.util.Scanner;

/**
 * 判断用户输入的数是奇数还是偶数
 *
 * @author YeYaqiao
 */
public class OddOrEven {

    public static void main(String[] args) {

        System.out.println("请输入一个整数");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        if (num % 2 == 0)
            System.out.printf("%d 是偶数", num);
        else
            System.out.printf("%d 是奇数", num);
    }
}
