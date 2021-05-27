package juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author YeYaqiao
 * 重入锁 ReentrantLock 锁几次解几次，可以中断线程
 */
public class MyReentrantLock {

    private static int num;
    private final ReentrantLock reentrantLock = new ReentrantLock();

    public void count() {
        try {
//            可中断锁
            reentrantLock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num++;
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "是第" + num + "访问的");
        reentrantLock.unlock();
    }

    public static void main(String[] args) {
        MyReentrantLock account = new MyReentrantLock();
        //lambda 表达式写法,推荐这种写法，可以将资源和任务 runnable 分开
        Thread thread = new Thread(account::count, "线程1号");
        thread.start();
        thread.interrupt();

    }

}


