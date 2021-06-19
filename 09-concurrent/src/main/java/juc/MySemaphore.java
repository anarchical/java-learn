package juc;

import java.util.concurrent.Semaphore;

/**
 * @author YeYaqiao
 * 信号量
 * 初始化访问资源的许可数量、获取许可、释放许可
 */
public class MySemaphore {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(5);//初始化许可的数量

        for (int i = 1; i <= 15; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();//当前线程尝试获取访问许可
                    System.out.println(Thread.currentThread().getName() + "开始访问");
                    Thread.sleep(2000);//休眠两秒，模拟其它操作
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + "访问结束");
                    semaphore.release();//释放许可
                }
            }, "线程" + i).start();
        }
    }
}
