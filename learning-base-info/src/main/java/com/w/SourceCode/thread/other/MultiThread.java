package com.w.SourceCode.thread.other;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @ClassName MultiThread
 * @Description [多线程]
 * @Author ANGLE0
 * @Date 2020/6/8 10:43
 * @Version V1.0
 **/
public class MultiThread {
    public static void main(String[] args) {
        //获取线程管理
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //获取线程堆栈信息,排除：线程monitor,线程synchronizer
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        //打印
        for(ThreadInfo threadInfo : threadInfos){
            System.out.println("[" + threadInfo.getThreadId() + ", "+threadInfo.getThreadName() + "]");
        }
    }
    /**
     * [6, Monitor Ctrl-Break]  监控线程
     * [5, Attach Listener] 监听线程
     * [4, Signal Dispatcher]   向JVM发送消息的线程
     * [3, Finalizer]   调用线程finalizer的线程
     * [2, Reference Handler]   清除引用的线程
     * [1, main]    用户程序入口
     * */
}
