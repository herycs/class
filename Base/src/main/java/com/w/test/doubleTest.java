package com.w.test;

/**
 * @ClassName doubleTest
 * @Description [测试double格式化输出]
 * @Author ANGLE0
 * @Date 2020/5/1 12:19
 * @Version V1.0
 **/
public class doubleTest {
    public static void main(String[] args) {
        for (double i = 0.00d; i < 1 ; i+=0.05) {
            System.out.println("结果"+i%100);
        }

        //50 75
        Double sum = 0.80d;
        for ( ;sum != 1.00;) {
            sum*=2;
            System.out.println(sum % 1);
            if (sum>1){
                sum-=1;
            }
        }
    }
}
