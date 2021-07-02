package generic;

/**
 * @author YeYaqiao
 * 编写更通用的代码，能够适用“非特定的类型”，而不是一个具体的接口或类。
 * 其中 <E> 只是一个占位符
 * 通常使用
 */
public class MyGeneric<E> {

    private E name;

    public MyGeneric(E name) {
        this.name = name;
    }

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }

    public static void main(String[] args) {

        MyGeneric<String> myGeneric = new MyGeneric<>("generic");
        System.out.println(myGeneric.getName());

        MyGeneric<Integer> num = new MyGeneric<>(100);
        System.out.println(num.getName());

    }
}
