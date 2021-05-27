package join;

/**
 * @author YeYaqiao
 * 线程合并 join()
 */
public class MyJoin implements Runnable {


    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println("myRunnable 线程执行：" + i);
        }

    }

    public static void main(String[] args) throws InterruptedException {

        MyJoin myJoin = new MyJoin();
        Thread thread = new Thread(myJoin);

        // thread 线程启动，开始和 main 线程交替执行
        thread.start();
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                System.out.println("MyJoin 线程开始执行");
                // main 线程阻塞，thread 线程获得（不是独占） CPU 一直到执行完毕
                thread.join();
            }
            //一开始交替运行，后来被阻塞直到 thread 线程执行完，获得 CPU 后继续运行
            System.out.println("main 线程执行：" + i);
        }

    }

}
