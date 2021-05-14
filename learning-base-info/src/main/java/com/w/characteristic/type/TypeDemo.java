package com.w.characteristic.type;

/**
 * @ClassName TypeDemo
 * @Description [泛型测试]
 * @Author ANGLE0
 * @Date 2020/6/10 22:31
 * @Version V1.0
 **/
public class  TypeDemo <T extends Object>{
    private T num;

    public TypeDemo() {
    }

    public void setNum(T num) {
        this.num = num;
    }

    public T getNum(){
        return num;
    }
}
