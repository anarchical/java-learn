package deadlock;

/**
 * @author YeYaqiao
 * 死锁示例，哲学家就餐问题，两个哲学家，两根筷子
 */
public class MyDeadlock implements Runnable {

    //筷子编号
    private final int num;

    //筷子资源，用 static 修饰，类变量，表示各有一份
    private static final Object chopsticks1 = new Object();
    private static final Object chopsticks2 = new Object();

    //构造函数，指定哪个哲学家先拿到哪只筷子
    public MyDeadlock(int num) {
        this.num = num;
    }

    //num = 1 时，拿到 chopsticks1，等待 chopsticks2
    //num = 2 时，拿到 chopsticks2，等待 chopsticks1
    @Override
    public void run() {

        if (num == 1) {
            System.out.println(Thread.currentThread().getName() + "拿到了 chopsticks1，等待 chopsticks2");
            synchronized (chopsticks1) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (chopsticks2) {
                    System.out.println(Thread.currentThread().getName() + "用餐完毕！");
                }
            }
        }
        if (num == 2) {
            System.out.println(Thread.currentThread().getName() + "拿到了 chopsticks2，等待 chopsticks1");
            synchronized (chopsticks2) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (chopsticks1) {
                    System.out.println(Thread.currentThread().getName() + "用餐完毕！");
                }
            }
        }

    }

    public static void main(String[] args) {

        MyDeadlock myDeadlock1 = new MyDeadlock(1);
        MyDeadlock myDeadlock2 = new MyDeadlock(2);

        new Thread(myDeadlock1, "哲学家1号").start();
        new Thread(myDeadlock2, "哲学家2号").start();


    }
}
