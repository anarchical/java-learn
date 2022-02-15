package trylock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author YeYaqiao
 */
public class tryLock {

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                if (lock.tryLock(5, TimeUnit.SECONDS)) {
                    System.out.println("thread get lock");
                    lock.unlock();
                } else {
                    System.out.println("thread didn't get lock");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        lock.lock();
        System.out.println("main get lock");
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();

    }
}
