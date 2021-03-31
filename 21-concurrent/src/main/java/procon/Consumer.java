package procon;

import java.util.concurrent.TimeUnit;

/**
 * @author YeYaqiao
 * 消费者
 */
public class Consumer {

    private final Container container;

    public Consumer(Container container) {
        this.container = container;
    }

    public void consume() {
        for (int i = 0; i < 30; i++) {
            this.container.pop();

//            每隔一秒钟卖一个汉堡
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
