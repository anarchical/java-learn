package init;

import java.util.Arrays;

/**
 * @author YeYaqiao
 */
public class Array {

    public static void main(String[] args) {
//        int[] array = new int[]{1, 2, 3};创建数组时赋值
//        int[] array = {1, 2, 3};
        int[] array = new int[3];//数组初始化必须指定大小
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        System.out.println(Arrays.toString(array));

        int[][] a = {{1, 2, 3}, {1, 2}, {12, 32}};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.println(a[i][j]);
            }
        }
    }

}
