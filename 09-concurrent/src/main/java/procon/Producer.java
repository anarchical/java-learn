package procon;

import java.util.concurrent.TimeUnit;

/**
 * @author YeYaqiao
 * 生产者
 */
public class Producer {

    private final Container container;

    public Producer(Container container) {
        this.container = container;
    }

    public void product() {
        for (int i = 0; i < 30; i++) {
            Hamburger hamburger = new Hamburger(i);
            this.container.push(hamburger);

//            每隔一秒生产一个汉堡
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
