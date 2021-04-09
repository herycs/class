package com.w.base.interfaces;

/**
 * @ClassName Class1
 * @Description [类 1]
 * @Author ANGLE0
 * @Date 2020/7/22 20:15
 * @Version V1.0
 **/
//接口具有相同的方法实际并不冲突
public abstract class Class1 extends AbsClass implements InterfaceDemo, InterfaceDemo2{

    @Override
    public void fun() {
        System.out.println("123");
    }

}
