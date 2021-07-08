### 枚举

Enum 是一种确定取值区间的数据类型，本质上是一个类

枚举不能去继承或者实现，是一种特殊的类

```java
public enum Week {

    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURADAY,
    SUNDAY;

    public static void main(String[] args) {
        for (Week week : Week.values()) {
            System.out.println(week);
        }
    }
}
```

枚举类的 values() 方法可以返回一个包含所有枚举信息的数组

#### 构造器



#### 枚举方法

枚举中可以正常定义方法，同时也可以定义成员变量

```java
public enum Response {
    SUCCESS(1, "成功"),
    FAILED(0, "失败");

    private final Integer code;
    private final String message;

    Response(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static void main(String[] args) {

        System.out.println(Response.FAILED.getCode());
        System.out.println(Response.SUCCESS.getMessage());
    }
}
```

