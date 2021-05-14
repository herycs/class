package com.w.test;

import java.util.HashMap;

/**
 * @ClassName com.w.test
 * @Description [测试Math]
 * @Author ANGLE0
 * @Date 2020/5/4 22:10
 * @Version V1.0
 **/
public class test {
    public static void main(String[] args) {

        Integer i1 = 127;
        Integer i2 = 127;

        Integer i3 = 129;
        Integer i4 = 129;

        Integer i5 = new Integer(127);
        Integer i6 = new Integer(127);

        System.out.println(i1 == i2); // true
        System.out.println(i3 == i4); // false

        System.out.println(Integer.valueOf(127) == Integer.valueOf(127)); // true

        System.out.println(i5 == i6); // false
    }
    {
        System.out.println(Math.pow(2, 31));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(Math.abs(Integer.MIN_VALUE));
    }
}
