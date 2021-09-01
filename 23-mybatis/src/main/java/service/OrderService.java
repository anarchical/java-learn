package service;

import entity.Order;
import mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;
import util.SessionUtil;

/**
 * @author YeYaqiao
 * 关联查询
 */
public class OrderService {

    private static void order() {

        //开启连接会话
        SqlSession sqlSession = SessionUtil.getSession();
        //获取接口的实现(获取代理对象)
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        //增删改查
        //一对一查询

        Order order = mapper.findOrderAndClientByOrderId(2);
        System.out.println(order.getName());//延迟加载，只执行一条 SQL
//        System.out.println(order.getClient());


//        System.out.println(mapper.findAll());
//
//        //多对多查询
//        System.out.println(mapper.findCommoditiesByOrderId(2));
    }

    public static void main(String[] args) {
        order();
    }

}
