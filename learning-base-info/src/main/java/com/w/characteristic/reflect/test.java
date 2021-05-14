package com.w.characteristic.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName com.w.test
 * @Description [测试]
 * @Author ANGLE0
 * @Date 2020/6/10 15:09
 * @Version V1.0
 **/
public class test {
    public static void main(String[] args) throws Exception {

        Class aClass = Class.forName("com.w.characteristic.reflect.AnnotationTest");
            Method[] methods = aClass.getMethods();
            for(Method method : methods){
                if(method.isAnnotationPresent(AnnotationDemo1.class)){
                    AnnotationDemo1 name = method.getAnnotation(AnnotationDemo1.class);
                    System.out.println("id:" + name.id() +",desc:" + name.desc());
                    Object result = method.invoke(aClass.newInstance());
                    System.out.println("方法返回值为："+result);
                }
        }

    }

    public void DemoTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        DEMO demo = new DEMO();

        Class aClass = demo.getClass();

        Class bClass = DEMO.class;

        Class cClass = Class.forName("com.w.characteristic.reflect.DEMO");

        System.out.println(aClass == bClass);
        System.out.println(bClass == cClass);
        System.out.println(bClass.equals(cClass));

        Field age = aClass.getDeclaredField("age");
        age.set(demo, 12);

        Method method = aClass.getMethod("getAge");
        Object ageVal  = method.invoke(demo);
        System.out.println(ageVal);

        System.out.println(demo.age);
    }

    public void print(Class aClass){
        String name = aClass.getName();
        Field[] fileds = aClass.getFields();
        Field[] declaredFields = aClass.getDeclaredFields();
        Method[] methods = aClass.getMethods();
        Method[] declaredMethods = aClass.getDeclaredMethods();
//        Method getAge = aClass.getMethod("getAge");
        Constructor[] constructors = aClass.getConstructors();

        System.out.println("类名");
        System.out.println(name);
        System.out.println("字段列表");
        for (Field s : fileds){
            System.out.println(s.getName()+ s.getType().toString());
        }
        System.out.println("------------");
        for(Field s : declaredFields){
            System.out.println(s.toString());
        }
        System.out.println("方法列表");
        for(Method o1 : methods){
            System.out.println(o1.toString());
        }
        System.out.println("-------------");
        for(Method o2 : declaredMethods){
            System.out.println(o2.toString());
        }
        System.out.println("-------------");
//        System.out.println(getAge.getName()+" "+getAge.getParameters().toString());
        System.out.println("构造器");
        for (Constructor s : constructors){
            System.out.println(s.toString());
        }
        System.out.println("-------------");
    }
}
