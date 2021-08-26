package entity;

import lombok.Data;

import java.util.List;

/**
 * @author YeYaqiao
 * 客户
 */
@Data
public class Client {
    private Integer id;
    private String name;
    private List<Order> orders;
}
