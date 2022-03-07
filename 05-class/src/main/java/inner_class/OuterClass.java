package inner_class;

/**
 * @author YeYaqiao
 */
public class OuterClass {

    public void get() {
        System.out.println("outer");
    }

    class InnerClass {
        public void get() {
            System.out.println("inner");
        }
    }


    public static void main(String[] args) {
        OuterClass outerClass=new OuterClass();
        outerClass.get();

        OuterClass.InnerClass innerClass=outerClass.new InnerClass();

        innerClass.get();
    }
}
