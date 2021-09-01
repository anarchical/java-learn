package util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import service.ClientService;

import java.io.InputStream;

/**
 * @author YeYaqiao
 */
public class SessionUtil {

    public static SqlSession getSession() {
        //加载配置文件 config.xml
        InputStream inputStream = ClientService.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        //开启连接会话
        return factory.openSession();
    }
}
