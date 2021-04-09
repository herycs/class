package com.w.SourceCode.thread.other;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @ClassName RunnableDemo1
 * @Description [Runnable接口]
 * @Author ANGLE0
 * @Date 2020/6/8 17:51
 * @Version V1.0
 **/
public class CollableDemo1 implements Callable, Future {

    private static int times;
    private static int flag = 0;

    @Override
    public Object call() throws Exception {
        while (true) {
            times = new Random().nextInt(20);
            System.out.println("当前数字" + times);
            Thread.sleep(300);
            flag++;
            if (flag > 30){
                return this.times;
            }
        }
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public Object get() throws InterruptedException, ExecutionException {
        return this.times;
    }

    @Override
    public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    public static void main(String[] args) throws Exception {
        CollableDemo1 collableDemo1 = new CollableDemo1();
        ThreadDemo2 threadDemo2 = new ThreadDemo2(collableDemo1);

        threadDemo2.start();
        Object o = collableDemo1.call();

        System.out.println("共计" + o);
    }
}
