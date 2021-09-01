package service;

import entity.Client;
import mapper.ClientMapper;
import org.apache.ibatis.session.SqlSession;
import util.SessionUtil;

/**
 * @author YeYaqiao
 */
public class ClientService {

    private static void client() {

        //开启连接会话
        SqlSession sqlSession = SessionUtil.getSession();
        //获取接口的实现(获取代理对象)
        ClientMapper mapper = sqlSession.getMapper(ClientMapper.class);

        //增删改查
        //一对多查询
        Client client = mapper.findById(2);
        System.out.println(client);

    }

    public static void main(String[] args) {
        client();
    }
}
