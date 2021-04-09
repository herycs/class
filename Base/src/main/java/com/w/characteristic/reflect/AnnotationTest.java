package com.w.characteristic.reflect;

/**
 * @ClassName AnnotationTest
 * @Description [注册测试]
 * @Author ANGLE0
 * @Date 2020/6/10 17:14
 * @Version V1.0
 **/
public class AnnotationTest {
    @AnnotationDemo1(id = 12, desc = "name")
    public int show(){
        System.out.println("方法执行了");
        return 123;
    }
}
