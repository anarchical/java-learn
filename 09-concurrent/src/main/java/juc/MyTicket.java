package juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author YeYaqiao
 * 重入锁 ReentrantLock 锁几次解几次，可以中断线程
 * 多线程卖票案例
 */
public class MyTicket implements Runnable {

    //剩余票数
    private int ticketCount = 20000;
    //卖出票数
    private int selledCount = 0;

    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {

        while (ticketCount > 0) {
            lock.lock();//锁定 开始卖出一张票

            if (ticketCount == 0)//判断一下余票数量，若不为0则售票员线程开始卖票
                return;
            ticketCount--;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            selledCount++;
            System.out.printf("%s卖出了第%s张票\n", Thread.currentThread().getName(), selledCount);

            lock.unlock();// 一张票卖完，解锁
        }

    }

    public static void main(String[] args) {

        MyTicket myTicket = new MyTicket();

        Thread sell01 = new Thread(myTicket);
        sell01.setName("售票员1号");
        Thread sell02 = new Thread(myTicket);
        sell02.setName("售票员2号");

        sell01.start();
        sell02.start();
    }
}
