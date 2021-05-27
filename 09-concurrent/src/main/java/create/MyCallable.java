package create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author YeYaqiao
 * Callable 可以有返回值，并且可以抛出异常
 */
public class MyCallable implements Callable {

    @Override
    public Object call() throws Exception {
        return "Callable";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyCallable myCallable = new MyCallable();
        FutureTask futureTask = new FutureTask(myCallable);

        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println(futureTask.get());
    }
}
