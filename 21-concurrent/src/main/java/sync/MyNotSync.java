package sync;

/**
 * @author YeYaqiao
 * 非线程同步示例，共享任务 MyNotSync 的 run()
 * 当失去 CPU 资源时，其它线程可以随意插入 run(),导致访问顺序错乱
 */
public class MyNotSync implements Runnable {

    private static int num = 0;

    @Override
    public void run() {
        num++;
        System.out.println(Thread.currentThread().getName() + "是第" + num + "个访问的线程");

    }

    public static void main(String[] args) {

        //多个线程共享 mySync 任务
        MyNotSync mySync = new MyNotSync();

        for (int i = 1; i <= 10; i++) {
            Thread thread = new Thread(mySync, "线程" + i);
            thread.start();
        }
    }

}
