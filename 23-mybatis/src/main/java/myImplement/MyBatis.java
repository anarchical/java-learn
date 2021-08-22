package myImplement;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author YeYaqiao
 * 底层原理实现
 */
public class MyBatis implements InvocationHandler {

    private Object object;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
