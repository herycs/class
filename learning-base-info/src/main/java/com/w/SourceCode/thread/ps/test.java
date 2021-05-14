package com.w.SourceCode.thread.ps;

/**
 * @ClassName com.w.test
 * @Description [测试]
 * @Author ANGLE0
 * @Date 2020/6/7 19:22
 * @Version V1.0
 **/
public class test {
    public static void main(String[] args) throws InterruptedException {

        // 只实例化一个KFC对象，保证每一个服务员和用户在同一个KFC对象内
        Producter kfc = new Producter();

        //实例化4个客户对象
        Customer c1 = new Customer(kfc);
        Customer c2 = new Customer(kfc);
        Customer c3 = new Customer(kfc);
        Customer c4 = new Customer(kfc);

        //实例化3个服务员对象
        Waiter waiter1 = new Waiter(kfc);
        Waiter waiter2 = new Waiter(kfc);
        Waiter waiter3 = new Waiter(kfc);

        //让所有的对象的线程都开始工作
        waiter1.start();
        waiter2.start();
        waiter3.start();

        Thread.sleep(1000);

        c1.start();
        c2.start();
        c3.start();
        c4.start();
    }
}
