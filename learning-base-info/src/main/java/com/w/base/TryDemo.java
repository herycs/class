package com.w.base;

/**
 * @ClassName TryDemo
 * @Description [try catch实验]
 * @Author ANGLE0
 * @Date 2020/7/18 16:36
 * @Version V1.0
 **/
public class TryDemo {
    public static void main(String[] args) {

        System.out.println(test(3));

    }

    public static int test(int c){
        int a = 0;
        int b = 1;
        try{
            return a + c;
        }finally {
            return b + c;
        }
    }
}
