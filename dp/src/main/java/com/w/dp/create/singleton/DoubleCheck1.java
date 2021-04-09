package com.w.dp.create.singleton;

import java.io.Serializable;

/**
 * @ClassName DoubleCheck1
 * @Description [双重检查锁]
 * @Author ANGLE0
 * @Date 2020/8/29 10:12
 * @Version V1.0
 **/
public class DoubleCheck1 implements Serializable {

    private static final long serializableID = 4928832861296252415L;

    private volatile static DoubleCheck1 singleton;

    private DoubleCheck1() {}

    public static DoubleCheck1 getInstance() {
        if (singleton == null) {
            synchronized (DoubleCheck1.class) {
                if (singleton == null) {
                    singleton = new DoubleCheck1();
                }
            }
        }
        return singleton;
    }
    public Object readResolve() {
        return singleton;
    }
}
