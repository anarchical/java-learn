### Spring

* Spring Framework：是整个 Spring 的基础，是较为底层的内容
* Spring Boot：快速开发框架，便于集成各种服务
* Spring Cloud：整合了分布式应用常见模块的框架，可以实现微服务的快速开发

IOC 和 AOP 是 Spring 框架的核心

#### IOC

IOC（Inverse Of Controller）控制反转

将对象的创建不再交给开发者，而是交给 Spring 框架（程序），通过读取 xml 配置文件中的信息，使用反射机制获取到类型信息，创建出对象功能开发者直接调用

读取 xml 中配置的信息，通过反射机制来创建对象

基于 xml 配置文件生成对象

```xml
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.3.9</version>
        </dependency>
```

```java
@Data
public class com.leaf.User {

    private String name;
    private Integer age;
}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="user" class="com.leaf.User">
        <property name="name" value="张三"/>
        <property name="age" value="23"/>
    </bean>

</beans>
```

```java
public class Spring {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        Object user = applicationContext.getBean("user");
        System.out.println(user);
    }
}
```

基于注解生成对象

```java
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

```

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author YeYaqiao
 */
public class Spring {

    //通过注解生成对象
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.leaf");
        // bean 的名称默认为类名的小写，可以通过 @Component 的 value 属性进行修改
        Object user = applicationContext.getBean("User");
        System.out.println(user);
    }
}
```

@Component 和 @Bean 的区别

* @Component 作用于类，可以直接被实例化成对象；@Bean 作用于方法，通过方法返回对象
* 使用 @Bean 需要结合 @Configuration

##### MVC

```java
public class UserRepository {

    private static final HashMap<Integer, String> map = new HashMap<>();

    static {
        map.put(1, "张三");
    }

    public String getNameById(int id) {
        return map.get(id);
    }
}

public class UserService {

    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getNameById(int id) {
        return userRepository.getNameById(id);
    }
}

public class UserController {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getNameById(int id) {
        return userService.getNameById(id);
    }
}

public class Spring {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("mvc.xml");
        UserController userController=applicationContext.getBean("userController",UserController.class);
        System.out.println(userController.getNameById(1));
    }
}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="userController" class="mvc.UserController">
        <property name="userService" ref="userService"/>
    </bean>

    <bean id="userService" class="mvc.UserService">
        <property name="userRepository" ref="userRepository"/>
    </bean>

    <bean id="userRepository" class="mvc.UserRepository"/>

</beans>
```

@Autowired 可以自动注入接口的实现类；当一个接口有多个实现类时，需要配合 @Qualifier(value = "") 指明具体的实现类



#### AOP

AOP（Aspect Oriented Programming）面向切片编程



