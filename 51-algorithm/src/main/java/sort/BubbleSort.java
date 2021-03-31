package sort;

import java.util.Arrays;

/**
 * @author YeYaqiao
 * 冒泡排序
 * 最坏时间复杂度：O(n2)
 * 最好时间复杂度：O(n)
 * 平均时间复杂度：O(n2)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 */
public class BubbleSort {

    public static void sort(int[] array) {

        boolean isSwap = false;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {

                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    isSwap = true;
                }

                //若没有发生交换，则说明此数组是排好序的，直接返回，此时时间复杂度为O(n)
                if (!isSwap)
                    return;
            }
        }

    }


    public static void main(String[] args) {

        int[] array = new int[]{6, 5, 3, 2, 5, 1, 9, 8, 7, 0};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
