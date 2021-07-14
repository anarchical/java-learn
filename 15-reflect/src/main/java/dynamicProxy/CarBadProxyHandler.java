package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author YeYaqiao
 */
public class CarBadProxyHandler implements InvocationHandler {

    //委托对象
    private final Object object;

    //设置委托对象
    public CarBadProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //新增次要业务
        System.out.println("黑心代理，讨好客户");
        //执行委托类主要业务
        return method.invoke(this.object, args);
    }
}
