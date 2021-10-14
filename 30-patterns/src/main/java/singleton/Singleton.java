package singleton;

/**
 * @author YeYaqiao
 * <p>
 * 懒汉式
 * 线程不安全，单线程情况下使用
 */
//public class Singleton {
//
//    private static Singleton singleton;
//
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        if (singleton == null)
//            singleton = new Singleton();
//        return singleton;
//    }
//}


/**
 * 懒汉式线程安全
 */
//public class Singleton {
//
//    private static Singleton singleton;
//
//    private Singleton() {
//    }
//
//    public static synchronized Singleton getInstance() {
//        if (singleton == null)
//            singleton = new Singleton();
//        return singleton;
//    }
//}

/**
 * 饿汉式线程安全
 */
//public class Singleton {
//
//    private static final Singleton singleton = new Singleton();
//
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        return singleton;
//    }
//}

/**
 * 枚举单例
 * 饿汉式，线程安全
 */
//public enum SingletonEnum{
//    INSTANCE;
//    public void method(){};
//}

/**
 * 静态内部类
 * 懒汉式线程安全
 */
//public class Singleton {
//
//    /*
//    Singleton 类被装载了，instance 不一定被初始化。
//    因为 SingletonHolder 类没有被主动使用，只有通过显式调用 getInstance 方法时，
//    才会显式装载 SingletonHolder 类，从而实例化 instance。
//     */
//    private static class SingletonHolder {
//        private static final Singleton INSTANCE = new Singleton();
//    }
//
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        return SingletonHolder.INSTANCE;
//    }
//}

/**
 * 懒汉式双重校验锁
 * 线程安全
 */
public class Singleton {

    /*
    多线程模式下每个线程都是先在自己的缓存中创建数据，再将数据复制到主内存中进行使用
    若线程1在缓存中创建好对象但还没将其复制到主内存中时就失去CPU资源，线程2发现主内存中没有所需的对象，则会再次创建对象
    此时需要 volatile 关键字使线程间的缓存可见，防止额外创建对象
     */
    private static volatile Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null)
                    singleton = new Singleton();
            }
        }
        return singleton;
    }
}

