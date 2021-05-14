package com.w.dp.create.builder;

/**
 * @ClassName Builder
 * @Description [抽象建造者]
 * @Author ANGLE0
 * @Date 2020/4/29 17:18
 * @Version V1.0
 **/
public abstract class Builder<T> {
    abstract void buildShell();
    abstract void buildHardWare();
    abstract void buildSoftWare();
    public T getResult(){return null;}
}
