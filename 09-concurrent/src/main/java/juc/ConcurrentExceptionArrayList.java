package juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author YeYaqiao
 * 线程不安全和线程安全的 List 操作
 * ConcurrentModificationException 并发修改异常
 */
public class ConcurrentExceptionArrayList {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();//普通 ArrayList

        for (int i = 0; i < 100; i++) {
            // 创建多个线程对同一个 list 同时进行读写操作
            new Thread(() -> {
                list.add("a");//写操作
                System.out.println(list);//读操作
            }).start();

        }
    }

}

/**
 * 线程安全的List操作
 * CopyOnWriteArrayList
 */
class ConcurrentArrayList{

    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();//线程安全的List

        for (int i = 0; i < 100; i++) {
            // 创建多个线程对同一个 list 同时进行读写操作
            new Thread(() -> {
                list.add("a");//写操作
                System.out.println(list);//读操作
            }).start();

        }
    }
}
