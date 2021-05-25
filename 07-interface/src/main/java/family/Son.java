package family;

/**
 * @author YeYaqiao
 */
public class Son implements Father, Mother {

    @Override
    public void handsome() {
        System.out.println("实现了爸爸的帅");
    }

    @Override
    public void beauty() {
        System.out.println("实现了妈妈的美");
    }

    @Override
    public void rich() {
        Father.super.rich();
        Mother.super.rich();
    }

    public static void main(String[] args) {

        Son son = new Son();
        son.rich();
        son.beauty();
        son.handsome();
    }
}
