package com.w.SourceCode.thread.other;

import java.util.Random;

/**
 * @ClassName RunnableDemo1
 * @Description [Runnable测试]
 * @Author ANGLE0
 * @Date 2020/6/8 18:01
 * @Version V1.0
 **/
public class RunnableDemo1 implements Runnable{

    private int times = (new Random()).nextInt(10);

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println("第" + i + "次");
        }
    }
}
