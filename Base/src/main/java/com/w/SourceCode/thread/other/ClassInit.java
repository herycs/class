package com.w.SourceCode.thread.other;

/**
 * @ClassName ClassInit
 * @Description [类初始化]
 * @Author ANGLE0
 * @Date 2020/6/8 10:22
 * @Version V1.0
 **/
public class ClassInit {

    //定义在：class中的静态变量会在类初始化时交由JVM操作（而这是线程安全的）
    private static class InstanceHolder{
        public static ClassInit classInit = new ClassInit();
    }

    //获取实例方法：直接调用静态内部类中的静态实例即可
    public static ClassInit getInstance(){
        return InstanceHolder.classInit;
    }
}
