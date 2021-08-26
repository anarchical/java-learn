package service;

import entity.Client;
import mapper.ClientMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author YeYaqiao
 */
public class ClientService {

    private static void client() {

        //加载配置文件 config.xml
        InputStream inputStream = ClientService.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        //开启连接会话
        SqlSession sqlSession = factory.openSession();

        //获取接口的实现(获取代理对象)
        ClientMapper mapper = sqlSession.getMapper(ClientMapper.class);

        //增删改查
        Client client = mapper.findById(2);
        System.out.println(client);


    }

    public static void main(String[] args) {
        client();
    }
}
