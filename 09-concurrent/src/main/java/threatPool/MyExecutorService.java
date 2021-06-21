package threatPool;

import org.omg.PortableServer.ThreadPolicy;

import java.util.concurrent.*;

/**
 * @author YeYaqiao
 * 线程池
 * 7个核心参数：核心线程数、最大线程数、存活时间、时间单位、阻塞队列、线程工程、拒绝策略
 */
public class MyExecutorService {

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
                2, //核心线程数
                3, //最大线程数
                1L, //存活时间
                TimeUnit.SECONDS, //时间单位
                new ArrayBlockingQueue<>(2), //阻塞队列数
                Executors.defaultThreadFactory(), //线程工厂 当阻塞队列数和核心线程数饱和时，线程工厂开始创建新的线程，直到达到线程池最大线程数，再添加新的线程则触发拒绝策略
                new ThreadPoolExecutor.AbortPolicy()); //拒绝策略 （ThreadPoolExecutor.AbortPolicy()为直接抛异常）


        for (int i = 0; i < 5; i++) {

            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "run");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "end");
            });
        }
        executorService.shutdown();

    }

}
