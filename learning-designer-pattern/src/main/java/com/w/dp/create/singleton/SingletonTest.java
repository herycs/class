package com.w.dp.create.singleton;

import java.io.*;

/**
 * @ClassName SingletonTest
 * @Description [测试单例的序列化和反序列化]
 * @Author ANGLE0
 * @Date 2020/8/29 9:09
 * @Version V1.0
 **/
public class SingletonTest {
    public static void main(String[] args) throws Exception {
//        Class<?> aClass = Class.forName("com.w.designPattern.create.singleton.DoubleCheck1");
//        DoubleCheck1 d = (DoubleCheck1) aClass.getMethod("getInstance").invoke(Object.class);
//        DoubleCheck1 a = (DoubleCheck1) aClass.getMethod("getInstance").invoke(Object.class);
//
//        System.out.println(d == a);

        System.out.println("序列化 == 反序列化？" + (check() ? "yes" : "No"));

        while (true) {}
    }
    // 校验序列化结果
    public static boolean check() throws IOException, ClassNotFoundException {
        doSerializable();
        DoubleCheck1 d1 = reSerializable();
        DoubleCheck1 d2 = reSerializable();

        System.out.println("d1.toString = " + d1.toString());
        System.out.println("d2.toString = " + d2.toString());
        return d1 == d2;
    }
    // 序列化
    public static void doSerializable() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("ObjSerializable.txt"));
        objectOutputStream.writeObject(DoubleCheck1.getInstance());
        objectOutputStream.close();
    }
    // 反序列化
    public static DoubleCheck1 reSerializable() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("ObjSerializable.txt"));
        DoubleCheck1 resObj =  (DoubleCheck1) objectInputStream.readObject();
        objectInputStream.close();
        return resObj;
    }
}
