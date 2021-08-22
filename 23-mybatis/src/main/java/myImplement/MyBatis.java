package myImplement;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;

/**
 * @author YeYaqiao
 * 底层原理实现
 */
public class MyBatis implements InvocationHandler {

    private Object object;

    //为目标对象创建动态代理对象
    public Object getInstance(Class clazz) {
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //获取数据库连接
        //dom4j 读取 config.xml 获取连接信息
        SAXReader reader = new SAXReader();
        //设置不解析头部 DTD，否则会导致超时
        reader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        Document document = reader.read("23-mybatis/src/main/resources/config.xml");
        Element element=document.getRootElement();
        Iterator<Element> iterator=element.elementIterator();
        while(iterator.hasNext()){
            Element next=iterator.next();
            System.out.println(next.getName());
        }


        return null;
    }
}
