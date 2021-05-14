package com.w.base.extend;

/**
 * @ClassName Test
 * @Description [测试父子继承的加载信息]
 * @Author ANGLE0
 * @Date 2020/7/22 20:18
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {

//        initSon();

//        execM();
    }

    //父子类作为接受对象情况下，实际调用的方法还是实例化对象的
    private static void execM() {
        Extend ex = new Son();
        Son son = new Son();

        ex.show();
        son.show();
    }

    /**
     * Father static
     * Son static
     * Father constructor
     * Son constructor
     * */
    private static void initSon() {
        Son son = new Son();//父子加载过程
    }

}
