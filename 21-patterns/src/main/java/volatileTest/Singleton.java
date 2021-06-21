package volatileTest;

/**
 * @author YeYaqiao
 * 单例模式
 */
public class Singleton {

    private volatile static Singleton singleton;//工作内存可见

    private Singleton() {
    }

    public static Singleton getInstance() {

        if (singleton == null) { //提高效率
            synchronized (Singleton.class) { //线程同步
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }

}
