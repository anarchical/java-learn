package lambda;

/**
 * @author YeYaqiao
 */
public class ThreadLambda {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.println("HelloWorld");
            System.out.println("HelloLambda");
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
