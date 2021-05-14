package com.w.base.extend;

/**
 * @ClassName Son
 * @Description [子类]
 * @Author ANGLE0
 * @Date 2020/7/22 20:18
 * @Version V1.0
 **/
public class Son extends Extend {
    static {
        System.out.println("Son static");
    }

    public Son() {
        System.out.println("Son constructor");
    }

    public void show() {
        System.out.println("son");
    }

}
