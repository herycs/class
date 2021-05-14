package com.w.SourceCode.thread.ps;

/**
 * @ClassName Customer
 * @Description [消费者]
 * @Author ANGLE0
 * @Date 2020/6/7 19:17
 * @Version V1.0
 **/
public class Customer extends Thread{
    private Producter producter;

    public Customer(Producter producter) {
        this.producter = producter;
    }

    @Override
    public void run() {
        int size = (int) (Math.random()*5);
        while (true){
            producter.consu(size);
        }
    }
}
