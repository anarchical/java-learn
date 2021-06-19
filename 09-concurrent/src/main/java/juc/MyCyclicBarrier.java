package juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author YeYaqiao
 * 加法计数器
 * 当 await() 被调用指定的次数后，加法计数器清零，cyclicBarrier 中的线程被执行
 * 若 await() 执行的次数不等于加法计数器的倍数，则加法计数器所持有的线程处于阻塞状态
 */
public class MyCyclicBarrier {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {
            System.out.println("放行");
        });

        for (int i = 0; i < 40; i++) {

            final int temp = i;
            new Thread(() -> {
                System.out.println(temp);
                try {
                    cyclicBarrier.await();//加法计数器执行一次
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
