package com.w.SourceCode.thread.demo1;

/**
 * @ClassName com.w.test
 * @Description [测试，线程通信]
 * @Author ANGLE0
 * @Date 2020/6/7 19:33
 * @Version V1.0
 **/
public class test {
    /**
     * 两个人AB通过一个账户A在柜台取钱和B在ATM机取钱
     * */
    public static void main(String[] args) {
        // 实力化一个银行对象
        Bank bank = new Bank();
        // 实例化两个人，传入同一个银行的对象
        Son pA = new Son(bank);
        Sister pB = new Sister(bank);
        // 两个人开始取钱
        pA.start();
        pB.start();
    }
}
