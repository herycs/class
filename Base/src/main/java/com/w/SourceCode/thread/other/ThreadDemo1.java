package com.w.SourceCode.thread.other;

import java.text.SimpleDateFormat;

/**
 * @ClassName threadDemo1
 * @Description [线程实验1]
 * @Author ANGLE0
 * @Date 2020/6/7 17:51
 * @Version V1.0
 **/
public class ThreadDemo1 extends Thread {

    public ThreadDemo1(String name) {
        super(name);
    }

    static int ticketNum = 200;

    @Override
    public void run() {
        while (ticketNum > 0) {
            synchronized (this) {
                if (ticketNum > 0) {
                    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis())+" "+getName() + "：" + ticketNum--);
                } else {
                    System.out.println(getName()+" 汇报：票告罄！！！");
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo1 threadDemo1 = new ThreadDemo1("Staff 1");
        ThreadDemo1 threadDemo11 = new ThreadDemo1("Staff 2");
        ThreadDemo1 threadDemo12 = new ThreadDemo1("Staff 3");

        threadDemo1.start();
        threadDemo11.start();
        threadDemo12.start();
    }

    /**
     * 2020-06-07 18:36:52Staff 1：5
     * 2020-06-07 18:36:52Staff 2：4
     * 2020-06-07 18:36:52Staff 3：3
     * 2020-06-07 18:36:53Staff 1：2
     * 2020-06-07 18:36:53Staff 2：1
     * Staff 3汇报：票告罄！！！
     * */
}
