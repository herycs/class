package com.w.base;

import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName InnerClassTest
 * @Description [内部类测试]
 * @Author ANGLE0
 * @Date 2020/8/25 23:39
 * @Version V1.0
 **/
public class InnerClassTest {

    static class C1{
        private String sa = "";

        private void run2(){
            System.out.println("run2 private");
        }

        public void run1(){
            System.out.println("run1 public");
        }

        public static void run(){ }
    }

    private class C2{

    }
    protected class C3{

    }

    class C4{

    }

    public class C5 {

    }

}
