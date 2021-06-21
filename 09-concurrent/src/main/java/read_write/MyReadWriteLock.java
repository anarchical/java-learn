package read_write;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author YeYaqiao
 * 创建一个缓存类，模拟多线程读写
 * 读写锁
 * 写锁（独占锁）
 * 读锁（共享锁）
 */
public class MyReadWriteLock {

    public static void main(String[] args) {
        Cache cache = new Cache();

        //五个线程写操作
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                cache.write(temp, String.valueOf(temp));
            }).start();
        }

        //五个线程读操作
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                cache.read(temp);
            }).start();
        }
    }

}

class Cache {

    private final Map<Integer, String> cache = new HashMap<>();

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void write(Integer key, String value) {
        readWriteLock.writeLock().lock();

        System.out.println("write key: " + key + " value:" + value);
        cache.put(key, value);
        System.out.println("write done: " + key);

        readWriteLock.writeLock().unlock();
    }

    public void read(Integer key) {
        readWriteLock.readLock().lock();

        System.out.println("read key:" + key);
        System.out.println("read done value:" + cache.get(key));

        readWriteLock.readLock().unlock();
    }

}
