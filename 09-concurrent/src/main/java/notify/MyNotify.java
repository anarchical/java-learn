package notify;

import java.util.concurrent.TimeUnit;

/**
 * @author YeYaqiao
 * 线程唤醒
 * 只有拥有当前对象锁的线程，才能执行对象的 notify() 或 notifyAll(),（否则抛出异常 IllegalMonitorStateException）
 */
public class MyNotify {

    public synchronized void run(int i) {

        if (i == 6) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("run: " + i);
    }

    public synchronized void notifyRun() {
        this.notify();
    }

    public static void main(String[] args) {

        MyNotify myNotify = new MyNotify();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myNotify.run(i);
            }
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(8);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myNotify.notifyRun();
        }).start();
    }
}
