package threadlocal;

/**
 * @author YeYaqiao
 */
public class Demo {
    private final ThreadLocal<String> threadLocal=new ThreadLocal<>();

    public String getContent() {
        return threadLocal.get();
    }

    public void setContent(String content) {
        threadLocal.set(content);
    }

    public static void main(String[] args) {
        Demo demo = new Demo();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                    demo.setContent(Thread.currentThread().getName() + " content");
                    System.out.println(Thread.currentThread().getName() + "--->" + demo.getContent());

            },String.valueOf(i)).start();

        }
    }
}
