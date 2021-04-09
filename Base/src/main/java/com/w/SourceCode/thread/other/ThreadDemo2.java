package com.w.SourceCode.thread.other;

import java.util.concurrent.ExecutionException;

/**
 * @ClassName ThreadDemo2
 * @Description [thread for Collable]
 * @Author ANGLE0
 * @Date 2020/6/8 18:20
 * @Version V1.0
 **/
public class ThreadDemo2 extends Thread {

    private static CollableDemo1 collableDemo1;

    public ThreadDemo2(CollableDemo1 collableDemo1) {
        this.collableDemo1 = collableDemo1;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(collableDemo1.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
    }
}
