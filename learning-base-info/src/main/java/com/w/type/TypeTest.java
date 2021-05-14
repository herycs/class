package com.w.type;

/**
 * @ClassName TypeTest
 * @Description [泛型测试]
 * @Author ANGLE0
 * @Date 2020/8/27 22:18
 * @Version V1.0
 **/
public class TypeTest {
    public static void main(String[] args) {
        TypeDemo<Integer, Type> integerTypeTypeDemo = new TypeDemo<Integer, Type>();
        System.out.println(integerTypeTypeDemo.hashCode());
    }
}
