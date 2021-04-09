package com.w.dp.create.simpleFactory;

/**
 * @ClassName Factory
 * @Description [工厂]
 * @Author ANGLE0
 * @Date 2020/4/29 15:02
 * @Version V1.0
 **/
public class SimpleFactory{

    public ProductA createA(){
        return new ProductA();
    }

    public ProductB createB(){
        return new ProductB();
    }
}
