package com.w.base.extend;

/**
 * @ClassName Extend
 * @Description [继承类的加载关系]
 * @Author ANGLE0
 * @Date 2020/7/22 20:07
 * @Version V1.0
 **/
public class Extend {

    static {
        System.out.println("Father static");
    }

    public Extend() {
        System.out.println("Father constructor");
    }

    public void show(){
        System.out.println("father");
    }

    //不可被重写
    public final void finalFun(){
        System.out.println("final fun");
    }

}