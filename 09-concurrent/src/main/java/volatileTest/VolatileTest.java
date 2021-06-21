package volatileTest;

/**
 * @author YeYaqiao
 * 工作内存 主内存 演示例子
 */
public class VolatileTest extends Thread {
    //共享变量 flag
//    public boolean flag = false; //内存不可见 主线程不能得到 flag = true
    public volatile boolean flag = false; //内存可见，主线程能读到 flag = true

    @Override
    public void run() {
        try {
            Thread.sleep(10);//保证主线程先执行读取 flag=false
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("thread change flag to true"); //flag = true 循环却没有结束
    }

    public static void main(String[] args) {

        VolatileTest v = new VolatileTest();
        v.start();

        while (true) {
            if (v.flag) {
                System.out.println("flag is true");
                break;
            }
        }
    }
}



