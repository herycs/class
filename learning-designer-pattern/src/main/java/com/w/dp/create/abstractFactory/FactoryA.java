package com.w.dp.create.abstractFactory;

/**
 * @ClassName factoryA
 * @Description [具体工厂A]
 * @Author ANGLE0
 * @Date 2020/4/29 16:03
 * @Version V1.0
 **/
public class FactoryA extends Factory<ProductA, ProductB> {
    @Override
    public ProductA createA() {
        return new proda1();
    }

    @Override
    public ProductB createB() {
        return new prodb1();
    }
}
