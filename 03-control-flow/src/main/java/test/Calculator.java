package test;

import java.util.Scanner;

/**
 * 实现计算器功能，用户输入两个操作数，一个运算符（＋，-，×，/），输出结果
 *
 * @author YeYaqiao
 */
public class Calculator {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("请输入第一个数字");
        double a = in.nextDouble();

        System.out.println("请输入一个操作符");
        char operator = in.next().charAt(0);

        System.out.println("请输入第二个数字");
        double b = in.nextDouble();

        switch (operator) {
            case '+':
                System.out.printf("相加结果为：%f", a + b);
                break;
            case '-':
                System.out.printf("相加结果为：%f", a - b);
                break;
            case '*':
                System.out.printf("相乘结果为：%f", a * b);
                break;
            case '/':
                System.out.printf("相除结果为：%f", a / b);
        }

    }


}
