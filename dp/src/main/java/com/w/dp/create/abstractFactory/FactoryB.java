package com.w.dp.create.abstractFactory;

/**
 * @ClassName factoryB
 * @Description [具体工厂B]
 * @Author ANGLE0
 * @Date 2020/4/29 16:03
 * @Version V1.0
 **/
public class FactoryB extends Factory<ProductA, ProductB> {
    @Override
    public ProductA createA() {
        return new proda2();
    }

    @Override
    public ProductB createB() {
        return new prodb2();
    }

}
