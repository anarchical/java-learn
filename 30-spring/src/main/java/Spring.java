import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author YeYaqiao
 */
public class Spring {
    //通过读取 xml 配置文件生成对象
//    public static void main(String[] args) {
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
//        Object user = applicationContext.getBean("user");
//        System.out.println(user);
//    }

    //通过注解生成对象
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.leaf");
        // bean 的名称默认为类名的小写，可以通过 @Component 的 value 属性进行修改
        Object user = applicationContext.getBean("User");
        System.out.println(user);
    }
}
