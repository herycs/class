package com.w.test;

import java.util.Scanner;

/**
 * @ClassName HashCodeTest
 * @Description [测试HashCode]
 * @Author ANGLE0
 * @Date 2019/12/26 9:39
 * @Version V1.0
 **/
public class HashCodeTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        while (!a.equals("q")){
            System.out.println(a.hashCode());
            a = in.nextLine();
        }
    }
}
