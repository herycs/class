package com.w.dp.create.abstractFactory;

/**
 * @ClassName Factory
 * @Description [抽象工厂]
 * @Author ANGLE0
 * @Date 2020/4/29 15:50
 * @Version V1.0
 **/
public abstract class Factory<T, E> {
    abstract T createA();
    abstract E createB();
}
