package com.w.characteristic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName AnnotationDemo
 * @Description [注解实验]
 * @Author ANGLE0
 * @Date 2020/7/18 16:44
 * @Version V1.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationDemo {
    int age() default 0;
    String desc() default "暂无说明";
}
