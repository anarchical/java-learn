package procon;

/**
 * @author YeYaqiao
 * 容器类,存放汉堡
 */
public class Container {

    private final Hamburger[] hamburgerArray = new Hamburger[6];

    private int index;

    /**
     * 生产了一个汉堡
     *
     * @param hamburger 汉堡
     */
    public synchronized void push(Hamburger hamburger) {

        //容器中放满了汉堡
        while (index == hamburgerArray.length) {
            try {
                System.out.println("满了");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();

        hamburgerArray[index] = hamburger;
        index++;
        System.out.println("生产了一个汉堡" + hamburger);
    }

    /**
     * 消费了一个汉堡
     */
    public synchronized void pop() {

        while (index == 0) {
            try {
//                当容器中没有汉堡时,则让线程阻塞等待
                System.out.println("没了");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
//        唤醒线程
        this.notify();

        index--;
        System.out.println("消费了一个汉堡" + hamburgerArray[index]);
    }

}
