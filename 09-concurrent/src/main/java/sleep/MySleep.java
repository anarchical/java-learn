package sleep;

/**
 * @author YeYaqiao
 * 线程休眠 sleep()，不释放锁
 */
public class MySleep implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                System.out.println("MySleep 线程开始休眠5s");
                try {
                    //MySleep线程休眠5s
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("MySleep 线程执行" + i);
        }

    }

    public static void main(String[] args) throws InterruptedException {

        MySleep mySleep = new MySleep();
        Thread thread = new Thread(mySleep);
        thread.start();

        //main主线程休眠300ms
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                System.out.println("main 线程开始休眠500ms");
                Thread.sleep(500);
            }
            System.out.println("main 线程执行" + i);
        }

    }
}
