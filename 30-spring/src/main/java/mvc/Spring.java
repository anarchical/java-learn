package mvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author YeYaqiao
 */
public class Spring {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("mvc.xml");
        UserController userController=applicationContext.getBean("userController",UserController.class);
        System.out.println(userController.getNameById(1));
    }
}
