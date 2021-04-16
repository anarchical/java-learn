package search;

import java.util.Arrays;

/**
 * @author YeYaqiao
 * 二分查找（适用于排好序的顺序存储）
 * 时间复杂度：O(logN)
 */
public class BinarySearch {

    public static boolean search(int[] array, int target) {
        Arrays.sort(array);
        int start = 0;
        int end = array.length - 1;
        int middle = end + (start - end) / 2;
        while (start < end) {

            if (array[middle] == target) {
                return true;
            }else if(array[middle]<target){
                end=middle;
            }else if(array[middle]>target){
                start=middle;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] array = new int[]{6, 5, 3, 2, 5, 1, 9, 8, 7, 0};
        search(array, 1);
    }

}
