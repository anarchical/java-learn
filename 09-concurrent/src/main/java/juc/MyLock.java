package juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author YeYaqiao
 * Lock 功能与 synchronized 一样，Lock相当于手动档，synchronized 相当于自动档
 * 使用 lock() 加锁以后，一定要记得使用 unlock() 解锁
 */
public class MyLock implements Runnable {

    private static int num;

    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {

        //加锁操作
        lock.lock();
        num++;
        System.out.println(Thread.currentThread().getName() + "是第" + num + "访问的");
        //解锁操作
        lock.unlock();
    }

    public static void main(String[] args) {
        MyLock myLock = new MyLock();
        Thread thread1 = new Thread(myLock, "线程1号");
        Thread thread2 = new Thread(myLock, "线程2号");

        thread1.start();
        thread2.start();
    }
}
