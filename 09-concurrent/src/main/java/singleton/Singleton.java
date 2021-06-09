package singleton;

/**
 * @author YeYaqiao
 * 线程安全的单例模式
 */
public class Singleton {

    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {

        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }

}
