package interrupted;

/**
 * @author YeYaqiao
 */
public class MyInterrupted {

    public static void main(String[] args) {
        Thread t1=new Thread(() -> {
            System.out.println("start t1");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end t1");
        });
        t1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("start interrupted");
        t1.interrupt();
    }
}
