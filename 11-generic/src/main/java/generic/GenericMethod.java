package generic;

/**
 * @author YeYaqiao
 */
public class GenericMethod {

    public <T> void print(T info){
        System.out.println(info);
    }

    public static void main(String[] args) {
        GenericMethod genericMethod=new GenericMethod();
        genericMethod.print("泛型方法");
    }
}
