package aop;

import org.springframework.stereotype.Component;

/**
 * @author YeYaqiao
 */
@Component
public class Method {

    public String add(){
        System.out.println("add");
        return "add";
    }

    public void sub(Integer num1,Integer num2){
        System.out.println("sub");
        System.out.println(num1+num2);
    }

}
