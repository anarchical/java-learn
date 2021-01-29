package create;

/**
 * @author YeYaqiao
 * 实现 Runnable 接口，单独定义任务，降低耦合度
 * 使用时创建 Thread 类，再将任务装入线程类中启动
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println("myRunnable 线程执行：" + i);
        }

    }


    public static void main(String[] args) {

        MyRunnable myRunnable = new MyRunnable();

        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);

        thread1.start();
        thread2.start();
    }
}
