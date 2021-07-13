package reflect;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author YeYaqiao
 * 通过反射获取类型信息
 */
public class MyClass {
    public static void main(String[] args) throws Exception {

        Dog dog = new Dog();

        String path = System.getProperty("user.dir") + File.separator +
                "15-reflect" + File.separator +
                "src" + File.separator + "main" + File.separator + "resources" + File.separator +
                "bean.properties";
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(path);
        properties.load(fileInputStream);

        String bean = properties.getProperty("bean");//bean="reflect.Dog"


        Class<?> clazz = Class.forName(bean);//通过全类名获取类型信息
        Class<Dog> clazz1 = Dog.class;//通过字面量获取类型信息
        Class<? extends Dog> clazz2 = dog.getClass();//通过对象获取类型信息

        System.out.println(clazz);
        System.out.println(clazz1);
        System.out.println(clazz2);
        //同一个类所获取的类型信息对象都是相同的

        //获取无参构造
        System.out.println(clazz.getConstructor());
        //获取有参构造
        System.out.println(clazz.getConstructor(String.class));
        //获取所有构造器信息
        System.out.println(Arrays.toString(clazz.getConstructors()));

        //通过反射创建对象
        Constructor<Dog> dogConstructor = clazz1.getConstructor();
        Dog reflectDog = dogConstructor.newInstance();

        //通过反射获取指定属性，若属性为私有，则使用 declared 获取
        //System.out.println(clazz.getField("name"));
        System.out.println(clazz.getDeclaredField("name"));
        //通过反射获取所有属性
        //System.out.println(Arrays.toString(clazz.getFields()));
        System.out.println(Arrays.toString(clazz.getDeclaredFields()));
        //通过反射给属性赋值，私有属性先设置 Accessible = true 暴力反射
        Field clazzField = clazz.getDeclaredField("name");
        clazzField.setAccessible(true);
        clazzField.set(reflectDog, "来福");

        //通过反射获取指定方法，若方法为私有，则使用 declared 获取
        System.out.println(clazz.getDeclaredMethod("setName", String.class));
        //通过反射获取所有方法(包括父类)
        System.out.println(Arrays.toString(clazz.getDeclaredMethods()));
        //通过反射调用方法，私有方法先设置 Accessible = true 暴力反射
        Method method = clazz.getDeclaredMethod("setName", String.class);
        method.setAccessible(true);
        method.invoke(reflectDog, "阿福");

        System.out.println(reflectDog);
        fileInputStream.close();
    }
}

@SuppressWarnings("unused")//忽略没有没使用的属性或方法的警告
class Dog {
    private String name;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}