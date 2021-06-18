package juc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeYaqiao
 * 线程不安全和线程安全的 List 操作
 * ConcurrentModificationException
 */
public class ConcurrentArrayList {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add("a");
                System.out.println(list);
            }).start();

        }
    }

}
