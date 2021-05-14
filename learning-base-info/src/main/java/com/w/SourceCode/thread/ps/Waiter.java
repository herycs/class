package com.w.SourceCode.thread.ps;

/**
 * @ClassName Waiter
 * @Description [服务员]
 * @Author ANGLE0
 * @Date 2020/6/7 19:21
 * @Version V1.0
 **/
public class Waiter extends Thread {

    private Producter producter;

    public Waiter(Producter producter) {
        this.producter = producter;
    }

    @Override
    public void run() {
        int size = (int) (Math.random()*6);
        while (true){
            producter.consu(size);
        }
    }
}
