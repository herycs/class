package com.w.characteristic.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName AnnotationDemo1
 * @Description [注解定义]
 * @Author ANGLE0
 * @Date 2020/6/10 17:08
 * @Version V1.0
 **/
@Target(ElementType.METHOD)//注解类型
@Retention(RetentionPolicy.RUNTIME)//注解保存级别
public @interface AnnotationDemo1{
    int id();
    String desc() default "none desc";
}

