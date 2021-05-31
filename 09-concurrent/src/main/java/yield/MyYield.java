package yield;

/**
 * @author YeYaqiao
 * 线程礼让 yield()
 */
public class MyYield implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println("myYield 线程执行：" + i);
        }
    }

    public static void main(String[] args) {

        MyYield myYield = new MyYield();
        Thread thread = new Thread(myYield);

        thread.start();
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                // 当 i=5 时，main线程暂停一下，myYield 线程会获取 CPU 资源继续执行
                System.out.println("main 线程 yield");
                Thread.yield();
            }
            System.out.println("main 线程执行：" + i);
        }
    }
}
