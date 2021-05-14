package com.w.SourceCode.WrapClass;

/**
 * @ClassName ShortDemo
 * @Description [Short包裝类测试]
 * @Author ANGLE0
 * @Date 2020/4/22 9:16
 * @Version V1.0
 **/
public class ShortDemo {

    public static void main(String[] args) {

    }

    private static void test1() {
        int i = 12;
        Integer integer = 12;
        int i1 = 10;
        System.out.println(i > 11 ? integer : i1);
        System.out.println(i < 11 ? i1 : integer);
        System.out.println(i <= 11 ? i1 : integer);
    }
}
