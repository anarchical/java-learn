[TOC]

### Lambda 表达式



#### 常用的 lambda 写法

##### 创建线程

```java
public class ThreadLambda {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.println("HelloWorld");
            System.out.println("HelloLambda");
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
```





