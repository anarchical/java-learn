package sellticket;

import java.util.concurrent.TimeUnit;

/**
 * @author YeYaqiao
 * 资源类
 */
public class Ticket {

    //剩余球票
    private int surpluCount = 15;
    //已售出球票
    private int outCount = 0;

    public void sell() {
        synchronized (Ticket.class){
            while (surpluCount > 0) {

                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (surpluCount == 0) {
                    return;
                }

                surpluCount--;
                outCount++;

                if (surpluCount == 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出了第" + outCount + "张票,卖光了!!!");
                } else {
                    System.out.println(Thread.currentThread().getName() + "卖出了第" + outCount + "张票");
                }
            }
        }

    }


}
