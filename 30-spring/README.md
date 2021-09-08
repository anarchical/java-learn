### Spring

* Spring Framework：是整个 Spring 的基础，是较为底层的内容
* Spring Boot：快速开发框架，便于集成各种服务
* Spring Cloud：整合了分布式应用常见模块的框架，可以实现微服务的快速开发

IOC 和 AOP 是 Spring 框架的核心

#### IOC

IOC（Inverse Of Controller）控制反转

将对象的创建不再交给开发者，而是交给 Spring 框架（程序），通过读取 xml 配置文件中的信息，使用反射机制获取到类型信息，创建出对象功能开发者直接调用

读取 xml 中配置的信息，通过工厂模式使用反射机制创建对象，通过 BeanFactory 或者 ApplicationContext 获取 IOC 容器（BeanFactory 加载配置文件并不直接创建对象，当对象被调用时才去创建；Application 是 BeanFactory 的子接口，提供更多的功能）

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

AOP（Aspect Oriented Programming）面向切面编程

AOP 是对 OOP 的一个补充，具体指在程序运行的过程中动态的将非业务代码（如日志打印，）切入到业务代码中，实现解耦；通过将非业务内容抽象成一个对象，面向该对象编程

* 优点

  降低模块之间的耦合、提高代码的维护性，提高代码复用性、将业务代码和非业务代码分离，使逻辑清晰

AOP 底层基于动态代理实现，委托类执行业务，代理类执行非业务逻辑

xml 配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/aop
       http://www.springframework.org/schema/aop/spring-aop-4.3.xsd">

    <context:component-scan base-package="aop"/>
    <aop:aspectj-autoproxy/>

</beans>
```

业务代码

```java
package aop;

import org.springframework.stereotype.Component;

/**
 * @author YeYaqiao
 */
@Component
public class Method {

    public String add(){
        System.out.println("add");
        return "add";
    }

    public void sub(Integer num1,Integer num2){
        System.out.println("sub");
        System.out.println(num1+num2);
    }

}
```

非业务代码（切面类）

```java
package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author YeYaqiao
 */
@Aspect
@Component
public class MyAspect {

    //方法用参数可以用占位符替代
    @After("execution(public void aop.Method.sub(..))")
    public void after(JoinPoint joinPoint){

        System.out.println("后执行");
        System.out.println("方法名："+joinPoint.getSignature().getName());
        System.out.println("方法参数："+ Arrays.toString(joinPoint.getArgs()));
    }

    @Before("execution(public void aop.Method.add())")
    public void before(JoinPoint joinPoint){

        System.out.println("先执行");
    }

    //
    @AfterReturning(value = "execution(public void aop.Method.add())",returning = "result")
    public void after(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint);
        System.out.println("结果是："+result);
    }
}

```

运行类

```java
package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author YeYaqiao
 */
public class Aop {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("aop.xml");
        Method bean = applicationContext.getBean(Method.class);
        System.out.println(bean.add());
        bean.sub(1,2);

    }
}
```


