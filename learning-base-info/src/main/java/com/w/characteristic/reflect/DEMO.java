package com.w.characteristic.reflect;

/**
 * @ClassName DEMO
 * @Description [操作类]
 * @Author ANGLE0
 * @Date 2020/6/10 15:04
 * @Version V1.0
 **/
public class DEMO{

    private int id;
    public String name;
    volatile int age;
    transient double money;

    public DEMO() {
    }

    public DEMO(int id) {
        this.id = id;
    }

    private void show(){
        return;
    }

    private synchronized void show1(){
        return;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
