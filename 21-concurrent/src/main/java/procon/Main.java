package procon;

/**
 * @author YeYaqiao
 * 启动类
 */
public class Main {
    public static void main(String[] args) {
        Container container = new Container();

        Producer producer = new Producer(container);
        Consumer consumer = new Consumer(container);

        new Thread(producer::product, "生产者").start();
        new Thread(consumer::consume, "消费者").start();
    }
}
