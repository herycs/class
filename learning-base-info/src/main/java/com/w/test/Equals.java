package com.w.test;

/**
 * @ClassName Equals
 * @Description [integer]
 * @Author ANGLE0
 * @Date 2020/4/19 16:43
 * @Version V1.0
 **/
public class Equals {
    public static void main(String[] args) {
        Integer num1, num2, num3, num4 ;

        num1 = -128;
        num2 = -128;

        num3 = 128;
        num4 = 128;

        System.out.println("when -128 <= integer <= 127");
        System.out.println(num1 == num2);

        System.out.println("when integer > 127 or integer < -128");
        System.out.println(num3 == num4);

    }
}
