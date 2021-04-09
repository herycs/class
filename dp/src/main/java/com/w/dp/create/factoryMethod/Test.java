package com.w.dp.create.factoryMethod;

/**
 * @ClassName Test
 * @Description [测试]
 * @Author ANGLE0
 * @Date 2020/4/29 15:40
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        Factory factory = new FactoryA();
        Product product = (Product) factory.create();
        product.use();
    }
}
