package com.leaf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author YeYaqiao
 */
@Data
// Component 将当前类生成的对象注入 IOC 容器中
@Component(value = "User")
public class User {

    @Value("张三")
    private String name;
    @Value("25")
    private Integer age;
}
