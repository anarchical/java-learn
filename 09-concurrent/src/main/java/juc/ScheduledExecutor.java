package juc;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author YeYaqiao
 * juc 定时任务
 */
public class ScheduledExecutor {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.println("定时任务执行");
        };

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        //第二个参数initialDelay表示第一次执行延迟的时间,0表示立即执行,period 表示循环周期
        service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);

    }
}
