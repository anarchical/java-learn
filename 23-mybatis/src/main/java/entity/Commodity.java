package entity;

import lombok.Data;

import java.util.List;

/**
 * @author YeYaqiao
 * 商品
 */
@Data
public class Commodity {
    private Integer id;
    private String name;
    private List<Order> orders;
}
