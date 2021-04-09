package com.w.local.dataStruct.queue;

/**
 * @ClassNameMyQueue
 * @Description
 * @Author ANGLE0
 * @Date 2019/12/22 14:43
 * @Version V1.0
 **/
public interface MyQueue {
    //初始化
    void InitQueue();
    //入队列
    void InQueue(Object data) throws Exception;
    //出队列
    Object OutQueue() throws Exception;
    //队头元素
    Object FrontQueue();
    //判空
    boolean EmptyQueue();
    //打印
    void display();
}
