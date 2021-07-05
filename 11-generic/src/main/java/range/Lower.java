package range;


import java.util.ArrayList;
import java.util.List;

/**
 * @author YeYaqiao
 * 泛型下限
 * 实例化对象时只能选用指定的类型或是其父类
 * 只能用来修饰方法参数
 */
public class Lower {

    public void print(List<? super String> list) {
        System.out.println("泛型下限" + list);
    }

    public static void main(String[] args) {

        Lower lower=new Lower();

        List<String> stringList=new ArrayList<>();
        lower.print(stringList);

        List<Object> objectList=new ArrayList<>();
        lower.print(objectList);
    }
}

