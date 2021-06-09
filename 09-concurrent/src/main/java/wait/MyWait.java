package wait;


import java.util.concurrent.TimeUnit;

/**
 * @author YeYaqiao
 * 线程等待
 * 只有拥有当前对象锁的线程，才能执行对象的 wait(),（否则抛出异常 IllegalMonitorStateException）主动释放锁并进入阻塞状态
 * 直到 wait() 超时或者 其它线程调用了对象的 notify() 或 notifyAll() 唤醒线程
 */
public class MyWait {

    public synchronized void run(int i) {

        if (i == 5) {
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

    public static void main(String[] args) {

        MyWait myWait = new MyWait();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myWait.run(i);
            }
        }).start();
    }

}
