package test;

/**
 * @author YeYaqiao
 */
public class MyException {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3};

        try {
            //try 中捕获可能发生的异常
            System.out.println(array[3]);
        } catch (Exception e) {
            //catch 中处理发生的异常
            e.printStackTrace();
        } finally {
            System.out.println("最后一定执行");
        }
    }
}
