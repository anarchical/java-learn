package math;

import java.math.BigDecimal;

/**
 * @author YeYaqiao
 * 数学工具类
 */
public class MyMath {

    public static void main(String[] args) {
        //自然对数的底数
        System.out.println(Math.E);
        //圆周率
        System.out.println(Math.PI);
        //9 的开平方
        System.out.println(Math.sqrt(9));
        //8的开立方
        System.out.println(Math.cbrt(8));
        //2的3次方
        System.out.println(Math.pow(2, 3));
        //两数最大
        System.out.println(Math.max(1, 9));
        //两数最小
        System.out.println(Math.min(1, 9));
        //求绝对值
        System.out.println(Math.abs(-10));
        //向下取整
        System.out.println(Math.floor(10.999));
        //向上取整
        System.out.println(Math.ceil(10.001));
        //四舍五入
        System.out.println(Math.round(5.60));
        //取随机数
        System.out.println(Math.random());
        //高精度小数
        System.out.println(new BigDecimal("0.1"));
    }
}
