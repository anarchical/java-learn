package threatPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author YeYaqiao
 * Executors 提供快速创建线程池
 */
public class MyExecutors {

    public static void main(String[] args) {

//        ExecutorService executors = Executors.newSingleThreadExecutor();//创建一个单例线程池，里面只有一个线程对象

//        ExecutorService executors = Executors.newFixedThreadPool(5);//快速创建一个指定数量的线程池 核心数和最大数一样

        ExecutorService executors = Executors.newCachedThreadPool();//由电脑配置自动分配线程数量

        for (int i = 0; i < 10; i++) {
            final int temp = i;
            executors.execute(() -> {
                System.out.println(Thread.currentThread().getName() + temp);
            });
        }

        executors.shutdown();
    }
}
