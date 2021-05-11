package test;

import java.util.Scanner;

/**
 * 用户循环输入4位数的会员号，判断是否为幸运会员(会员号的百位数等于指定数即为幸运会员，幸运数字自定义)，如果输入0则结束循环，使用do-while循环
 *
 * @author YeYaqiao
 */
public class LuckyMember {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int luckyNum = 6;
        int memberNum;

        do {
            System.out.println("请输入会员号");
            memberNum = in.nextInt();

            int result = memberNum / 100 % 10;

            if (memberNum == 0) {
                break;
            } else if (result == luckyNum) {
                System.out.printf("%d 是幸运会员\n", memberNum);
            } else {
                System.out.printf("%d 不是幸运会员\n", memberNum);
            }
        } while (true);
        System.out.println("退出");

    }
}
