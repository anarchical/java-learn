package myImplement;

import com.alibaba.druid.pool.DruidDataSource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author YeYaqiao
 * 底层原理实现
 */
public class MyBatis implements InvocationHandler {

    //配置文件路径信息
    private String configPath;

    //为目标对象创建动态代理对象，忽略泛型强转提示
    @SuppressWarnings("unchecked")
    public <T> T getInstance(Class<T> clazz, String configPath) {
        this.configPath = configPath;
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Map<String, String> databaseProperties = getDatabaseProperties();

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(databaseProperties.get("driver"));
        dataSource.setUrl(databaseProperties.get("url"));
        dataSource.setUsername(databaseProperties.get("username"));
        dataSource.setPassword(databaseProperties.get("password"));

        System.out.println(dataSource.getConnection());

        return null;
    }

    /**
     * 读取配置文件 config.xml
     *
     * @return 返回数据库连接信息
     */
    private Map<String, String> getDatabaseProperties() throws DocumentException {

        Map<String, String> result = new HashMap<>();

        //dom4j 读取 config.xml 获取连接信息
        SAXReader reader = new SAXReader();
        //设置不解析头部 DTD，防止解析太久导致超时
        //reader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        //获取 xml 文档内容
        Document document = reader.read(configPath);
        //开始解析元素，获取根元素（Iterator 用了遍历当前节点的所有子元素，next() 用来获取下一层的子元素）
        Element configuration = document.getRootElement();
        Iterator<Element> environmentIterator = configuration.elementIterator().next().elementIterator().next().elementIterator();
        while (environmentIterator.hasNext()) {
            Element element = environmentIterator.next();
            if (element.getName().equals("dataSource")) {
                Iterator<Element> dataSourceIterator = element.elementIterator();
                while (dataSourceIterator.hasNext()) {
                    element = dataSourceIterator.next();
                    result.put(element.attributeValue("name"), element.attributeValue("value"));
                }
            }
        }
        return result;
    }
}
