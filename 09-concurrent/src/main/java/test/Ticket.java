package test;

import java.util.concurrent.TimeUnit;

/**
 * @author YeYaqiao
 * 卖票同步案例
 */
public class Ticket {

    //剩余球票
    private int surpluCount = 10000;
    //已售出球票
    private int outCount = 0;

    public void sell() {
        try {
            TimeUnit.MILLISECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (Ticket.class){
            while (surpluCount > 0) {

                if (surpluCount == 0) {
                    return;
                }

                surpluCount--;
                outCount++;

                if (surpluCount == 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出了第" + outCount + "张票,卖光了!!!");
                } else {
                    System.out.println(Thread.currentThread().getName() + "卖出了第" + outCount + "张票");
                }
            }
        }

    }

    public static void main(String[] args) {
        Ticket ticket=new Ticket();

        new Thread(ticket::sell,"线程1").start();
        new Thread(ticket::sell,"线程2").start();
    }

}
