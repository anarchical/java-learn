package test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author YeYaqiao
 * 时钟打印
 */
public class Clock implements Runnable {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void run() {

        while (true) {

            Date date = new Date();
            System.out.println(simpleDateFormat.format(date));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Clock clock = new Clock();
        Thread thread = new Thread(clock);

        thread.start();
    }
}
