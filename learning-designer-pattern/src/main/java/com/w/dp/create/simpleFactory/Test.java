package com.w.dp.create.simpleFactory;

/**
 * @ClassName Test
 * @Description [测试]
 * @Author ANGLE0
 * @Date 2020/4/29 15:11
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();
        Product product = factory.createB();
        product.use();
    }
}
