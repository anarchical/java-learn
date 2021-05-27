package create;

/**
 * @author YeYaqiao
 * 继承 Thread 类，重写 Thread 中的 run 方法
 * 在线程中定义任务内容，不推荐使用，因为 Java 是单继承的，继承了 Thread 就不能继承其它的类了
 */
public class MyThread extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println("myThread 线程执行：" + i);
        }
    }

    public static void main(String[] args) {

        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.start();
        thread2.start();

    }
}
