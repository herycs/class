package com.w.characteristic.type;

/**
 * @ClassName TestType
 * @Description [测试]
 * @Author ANGLE0
 * @Date 2020/6/10 22:33
 * @Version V1.0
 **/
public class TestType {
    public static void main(String[] args) {

        TypeDemo typeDemo = new TypeDemo();
        typeDemo.setNum(123);
        System.out.println(typeDemo.getNum());

        typeDemo.setNum("com.w.test");


    }
}
