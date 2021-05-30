/**
 * @author YeYaqiao
 * 移位运算
 * >> 右移运算 num >> n 相当于 num / 2^n，符号位不变
 * << 左移运算 num << n 相当于 num * 2^n，符号位不变
 * >>> 无符号右移 num >>> n，符号位补0
 */
public class ShiftOperation {

    public static void main(String[] args) {

        int num;

//        左移
        num = 4;
        System.out.println(num << 1);
        num = -4;
        System.out.println(num << 1);

//        右移
        num = 16;
        System.out.println(num >> 1);
        num = -16;
        System.out.println(num >> 1);

//        无符号右移
        num = 16;
        System.out.println(num >>> 1);
        num = -16;
        System.out.println(num >>> 1);

    }
}
