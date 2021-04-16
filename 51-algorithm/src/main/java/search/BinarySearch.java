package search;

import java.util.Arrays;

/**
 * @author YeYaqiao
 * 二分查找（适用于排好序的顺序存储）
 * 时间复杂度：O(logN)
 * 空间复杂度：O(1)
 */
public class BinarySearch {

    public static boolean search(int[] array, int target) {
        Arrays.sort(array);

        int right = 0;
        int left = array.length - 1;
        int middle;

        while (right <= left) {
            middle = right + (left - right) / 2;

            if (array[middle] == target)
                return true;
            if (array[middle] < target)
                right = middle + 1;
            if (array[middle] > target)
                left = middle - 1;
        }

        return false;
    }

    public static void main(String[] args) {

        int[] array = new int[]{6, 5, 3, 2, 5, 1, 9, 8, 7, 0};
        System.out.println(search(array, 8));
    }

}
