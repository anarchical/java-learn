package lambda;

/**
 * @author YeYaqiao
 * lambda 表达式举例 runnable 接口定义任务内容
 */
public class MyLambda {

    public static void main(String[] args) {

//        传统写法
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("不是 lambda 表达式写法");
            }
        };
        runnable.run();

//        lambda 表达式写法
        Runnable lambda = () -> System.out.println("lambda 表达式写法");
        lambda.run();

    }

}
