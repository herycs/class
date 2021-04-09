package com.w.SourceCode.EnumDemo;

/**
 * @ClassName EnumDemo
 * @Description [enum枚举测试]
 * @Author ANGLE0
 * @Date 2020/4/22 11:13
 * @Version V1.0
 **/
public class EnumDemo {
    public enum course{
        math, java, os
    }

    public static course getOne(course o){
        switch (o){
            case math:
                return course.math;
            case java:
                return course.java;
            case os:
                return course.os;
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(getOne(course.java));
    }
}
