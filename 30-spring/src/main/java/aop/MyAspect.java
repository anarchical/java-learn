package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author YeYaqiao
 */
@Aspect
@Component
public class MyAspect {

    //方法用参数可以用占位符替代
    @After("execution(public void aop.Method.sub(..))")
    public void after(JoinPoint joinPoint){

        System.out.println("后执行");
        System.out.println("方法名："+joinPoint.getSignature().getName());
        System.out.println("方法参数："+ Arrays.toString(joinPoint.getArgs()));
    }

    @Before("execution(public void aop.Method.add())")
    public void before(JoinPoint joinPoint){

        System.out.println("先执行");
    }

    //
    @AfterReturning(value = "execution(public void aop.Method.add())",returning = "result")
    public void after(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint);
        System.out.println("结果是："+result);
    }
}
