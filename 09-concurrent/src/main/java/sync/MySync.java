package sync;

/**
 * @author YeYaqiao
 * 线程同步示例，使用 synchronized 关键字锁住共享任务 run()
 * 当失去 CPU 资源时其他线程不能执行插入执行被 synchronized 关键字修饰的代码块
 */
public class MySync implements Runnable {

    private static int num = 0;

    @Override
    public synchronized void run() {
        num++;
        System.out.println(Thread.currentThread().getName() + "是第" + num + "个访问的线程");
    }


    public static void main(String[] args) {

        //多个线程共享 mySync 任务
        MySync mySync = new MySync();

        for (int i = 1; i <= 10; i++) {
            Thread thread = new Thread(mySync, "线程" + i);
            thread.start();
        }
    }

}
