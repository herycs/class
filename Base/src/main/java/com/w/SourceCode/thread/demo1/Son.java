package com.w.SourceCode.thread.demo1;


/**
 * @ClassName Son
 * @Description [儿子]
 * @Author ANGLE0
 * @Date 2020/6/7 19:32
 * @Version V1.0
 **/
public class Son extends Thread{
    // 创建银行对象
    Bank bank;

    // 通过构造器传入银行对象，确保两个人进入的是一个银行
    public Son(Bank bank) {
        this.bank = bank;
    }

    //重写run方法，在里面实现使用柜台取钱
    @Override
    public void run() {
        while (Bank.money >= 100) {
            bank.Counter(100);// 每次取100块
            try {
                sleep(100);// 取完休息0.1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
