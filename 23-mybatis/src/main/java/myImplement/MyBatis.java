package myImplement;

import com.alibaba.druid.pool.DruidDataSource;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/**
 * @author YeYaqiao
 * 底层原理实现
 */
public class MyBatis implements InvocationHandler {

    //配置文件路径信息
    private String configPath;
    private String mapperPath;

    //为目标对象创建动态代理对象，忽略泛型强转提示
    @SuppressWarnings("unchecked")
    public <T> T getInstance(Class<T> clazz, String configPath) {
        this.configPath = configPath;
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Connection connection = getConnection();

        Map<String, String> parseStatement = parseStatement(method.getName());

        String sql = parseStatement.get("sql").replace("#{id}", "?");

        return executeSQL(
                connection,
                sql,
                parseStatement.get("resultType"),
                parseStatement.get("parameterType"),
                args);
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

        Iterator<Element> configurationIterator = configuration.elementIterator();
        while (configurationIterator.hasNext()) {
            Element element = configurationIterator.next();
            if (element.getName().equals("mappers")) {
                mapperPath = element.elementIterator().next().attributeValue("resource");
            }
        }

        return result;
    }

    /**
     * 获取连接信息
     *
     * @return 返回连接
     * @throws DocumentException dom4j
     * @throws SQLException      sql
     */
    private Connection getConnection() throws DocumentException, SQLException {
        Map<String, String> databaseProperties = getDatabaseProperties();

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(databaseProperties.get("driver"));
        dataSource.setUrl(databaseProperties.get("url"));
        dataSource.setUsername(databaseProperties.get("username"));
        dataSource.setPassword(databaseProperties.get("password"));

        return dataSource.getConnection();
    }

    /**
     * 根据方法名获取mapper中对应的 select 信息
     *
     * @param methodName 方法名
     * @return select
     * @throws DocumentException dom4j 读取异常信息
     */
    private Map<String, String> parseStatement(String methodName) throws DocumentException {
        Map<String, String> result = new HashMap<>();

        //dom4j 读取 config.xml 获取连接信息
        SAXReader reader = new SAXReader();
        //设置不解析头部 DTD，防止解析太久导致超时
        //reader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        //获取 xml 文档内容
        Document document = reader.read("23-mybatis/src/main/java/" + mapperPath);
        //开始解析元素，获取根元素（Iterator 用了遍历当前节点的所有子元素，next() 用来获取下一层的子元素）
        Element mapper = document.getRootElement();

        Iterator<Element> mapperIterator = mapper.elementIterator();
        while (mapperIterator.hasNext()) {
            Element element = mapperIterator.next();

            if (element.attributeValue("id").equals(methodName)) {
                for (Attribute attribute : element.attributes()) {
                    //添加属性名和对应的值
                    result.put(attribute.getName(), attribute.getValue());
                }
                //添加sql
                result.put("sql", element.getText());
            }
        }
        return result;
    }

    private Object executeSQL(Connection connection, String sql, String resultType, String parameterType, Object... args) throws SQLException, ClassNotFoundException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        switch (parameterType) {
            case "java.lang.Integer":
                preparedStatement.setInt(1, (Integer) args[0]);
                break;
            case "java.lang.String":
                preparedStatement.setString(1, (String) args[0]);
                break;
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        Class<?> clazz = Class.forName(resultType);
        return parseObject(resultSet, clazz);
    }

    private Object parseObject(ResultSet resultSet, Class<?> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException, NoSuchFieldException {
        Object object = clazz.getConstructor( null).newInstance( null);
        //解析结果集
        ResultSetMetaData metaData = resultSet.getMetaData();
        while (resultSet.next()) {
            String columnName;
            String columnType;
            Object value;
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                columnName = metaData.getColumnName(i);
                columnType = metaData.getColumnTypeName(i);
                switch (columnType) {
                    case "INT":
                        value = resultSet.getInt(columnName);
                        break;
                    case "VARCHAR":
                        value = resultSet.getString(columnName);
                        break;
                    default:
                        value = null;
                }
                //拼接方法名
                String methodName = "set" + columnName.substring(0, 1).toUpperCase(Locale.ROOT) + columnName.substring(1);
                Field declaredField = clazz.getDeclaredField(columnName);
                //获取方获取类的方法名
                Method method = clazz.getMethod(methodName, declaredField.getType());
                //调用这个对象的方法，并传入参数
                method.invoke(object, value);
            }
        }
        return object;
    }
}
