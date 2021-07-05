package generic;

/**
 * @author YeYaqiao
 * 编写更通用的代码，能够适用“非特定的类型”，而不是一个具体的接口或类。
 * 其中 <E> 只是一个占位符
 * 通常使用
 */
public class GenericClass<E> {

    private E name;

    public GenericClass() {
    }

    public GenericClass(E name) {
        this.name = name;
    }

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }

    public static void main(String[] args) {

        GenericClass<String> genericClass = new GenericClass<>("generic");
        System.out.println(genericClass.getName());

        GenericClass<Integer> num = new GenericClass<>();
        num.setName(100);
        System.out.println(num.getName());

    }
}
