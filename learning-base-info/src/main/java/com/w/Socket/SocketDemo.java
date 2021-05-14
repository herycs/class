package com.w.Socket;

import java.lang.reflect.Method;
import java.net.SocketImpl;

/**
 * @ClassName SocketDemo
 * @Description [socket API]
 * @Author ANGLE0
 * @Date 2020/7/18 16:39
 * @Version V1.0
 **/
public class SocketDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName(String.valueOf(SocketImpl.class));
        Method[] methods = aClass.getMethods();
        for (Method m : methods){
            System.out.println(m.getName());
        }
    }
}
