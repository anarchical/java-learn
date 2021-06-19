package juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author YeYaqiao
 * 减法计数器
 * 使用减法计数器的线程会在计数器清零前独占 CPU 运行，减法计数器设置的值减完之前，其它线程处于阻塞状态；减法计数器清零以后，唤醒其它的等待线程进入到就绪状态，等待获取 CPU 资源运行
 * 使用计数器的线程执行的总次数一定要大于等于计数器数，否则会导致计数器不能清零，不能唤醒其它线程，导致死锁
 */
public class MyCountDownLatch {

    public static void main(String[] args) {

        CountDownLatch count = new CountDownLatch(50);

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("线程一执行");
                count.countDown();
            }
        }).start();

        try {
            count.await(); //减法计数器设置的值减完之前，其它线程处于阻塞状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("线程二执行");
            }
        }).start();
    }
}

