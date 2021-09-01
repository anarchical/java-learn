package mapper;

import entity.Order;

import java.util.List;

/**
 * @author YeYaqiao
 */
public interface OrderMapper {
    Order findOrderAndClientByOrderId(int id);

    List<Order> findAll();

    Order findCommoditiesByOrderId(int id);
}
