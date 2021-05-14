package com.w.exam.demo5;

/**
 * @ClassName SingoleDemo1
 * @Description [单例]
 * @Author ANGLE0
 * @Date 2020/8/6 20:03
 * @Version V1.0
 **/
public class SingoleDemo1 {

    public volatile static SingoleDemo1 s = null;

    private SingoleDemo1() {
    }

    public SingoleDemo1 getS() {
        synchronized (this) {
            if (s == null)  {
                synchronized (this) {
                    s = new SingoleDemo1();
                }
            }
        }
        return s;
    }

}
