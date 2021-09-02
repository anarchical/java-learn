package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author YeYaqiao
 */
public class Aop {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("aop.xml");
        Method bean = applicationContext.getBean(Method.class);
        System.out.println(bean.add());
        bean.sub(1,2);

    }
}
