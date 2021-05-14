package com.w.base.interfaces;

/**
 * @ClassName Test
 * @Description [测试接口与继承]
 * @Author ANGLE0
 * @Date 2020/7/22 20:26
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        Class1 class1 = new Class1() {
            @Override
            public void run() {
                System.out.println(2);
            }
        };
        class1.fun();

        InterfaceDemo l = new InterfaceDemo() {
            @Override
            public void fun() {
                System.out.println("321");
            }
        };
        l.fun();
    }
}
