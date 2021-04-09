package com.w.characteristic.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName MyAnnotation
 * @Description [注解使用]
 * @Author ANGLE0
 * @Date 2020/7/18 16:50
 * @Version V1.0
 **/
public class MyAnnotation {

    static int age = -1;

    public static void setAge(int age) {
        MyAnnotation.age = age;
    }

    @AnnotationDemo(age = 10)
    public void rrr(){
        System.out.println("方法启动" + age);
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        Class<?> aClass = Class.forName("com.w.characteristic.annotation.MyAnnotation");

        Method rrr = aClass.getMethod("rrr");
        int age = rrr.getAnnotation(AnnotationDemo.class).age();
        String desc = rrr.getAnnotation(AnnotationDemo.class).desc();
        System.out.println(age + "--------" + desc);
    }

}
