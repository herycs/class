package com.w.local.dataStruct.queue;

/**
 * @ClassNameSeuQueue
 * @Description
 * @Author ANGLE0
 * @Date 2019/12/22 14:45
 * @Version V1.0
 **/
public class SeqQueue implements MyQueue {

    private int MAX_SIZE;
    private int DEAFULE_SIZE = 10;
    private Object[] data;
    private int front;
    private int rear;

    public SeqQueue() {
        this.InitQueue();
    }

    public SeqQueue(int size) {
        this.Init(size);
    }

    public void InitQueue() {
        this.Init(DEAFULE_SIZE);
    }

    public void InQueue(Object data) throws Exception {
        if (this.rear+1 == this.MAX_SIZE)
            throw new Exception("队列已满");
        this.data[++this.rear] = data;
    }

    public Object OutQueue() throws Exception {
        if (this.front+1 > this.rear)
            throw new Exception("队列已空");
        return this.data[++this.front];
    }

    public Object FrontQueue() {
        return this.data[this.front+1];
    }

    public boolean EmptyQueue() {
        return this.front+1 > this.rear;
    }

    //私有方法，给定初值初始化队列
    private void Init(int size){
        this.MAX_SIZE = size;
        this.data = new Object[this.MAX_SIZE];
        this.front = -1;
        this.rear = -1;
    }
    //打印
    public void display(){
        System.out.print("[");
        if (!this.EmptyQueue()){
            int index = this.front+1;
            while (index < this.rear){
                System.out.print(" "+this.data[index++]+",");
            }
            System.out.print(" "+this.data[index]);
        }
        System.out.print("]\n");
    }
}
