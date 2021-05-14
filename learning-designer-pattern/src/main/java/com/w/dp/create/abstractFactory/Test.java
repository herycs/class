package com.w.dp.create.abstractFactory;

/**
 * @ClassName Test
 * @Description [测试]
 * @Author ANGLE0
 * @Date 2020/4/29 16:29
 * @Version V1.0
 **/
public class Test {
    /*情景带入：
    *   工厂A---华为，B---小米
    *   产品A---手机，B---电脑*/
    public static void main(String[] args) {
        Factory factory = new FactoryA();
        ProductA productA = (ProductA) factory.createA();
        ProductB productB = (ProductB) factory.createB();

        productA.use();
        productB.start();
    }
}
