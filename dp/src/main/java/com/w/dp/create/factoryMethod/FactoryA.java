package com.w.dp.create.factoryMethod;

/**
 * @ClassName factoryA
 * @Description [具体工厂A]
 * @Author ANGLE0
 * @Date 2020/4/29 15:38
 * @Version V1.0
 **/
public class FactoryA extends Factory{
    @Override
    public productA create() {
        return new productA();
    }
}
