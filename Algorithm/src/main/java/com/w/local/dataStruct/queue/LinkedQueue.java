package com.w.local.dataStruct.queue;

/**
 * @ClassNameLinkedQueue
 * @Description
 * @Author ANGLE0
 * @Date 2019/12/22 15:49
 * @Version V1.0
 **/
public class LinkedQueue {

    class Node{
        Object data;
        Node next;
        public Node() {
        }
        public Node(Object data) {
            this.data = data;
        }
    }

    class Queue{
        //队头
        private Node front;
        //队尾
        private Node rear;
    }

    //当前队列
    private Queue queue;

    public LinkedQueue() {
        this.InitQueue();
    }

    //初始化
    public void InitQueue(){
        Node node = new Node();
        node.next = null;
        node.data = null;
        Queue queue = new Queue();
        queue.front = node;
        queue.rear = node;
        this.queue = queue;
    }
    //入队列
    public void InQueue(Object data) throws Exception{
        Node node = new Node(data);
        if (node == null)
            throw new Exception("申请节点失败，入队列失败");
        node.next = null;
        this.queue.rear.next = node;
        this.queue.rear = node;
    }
    //出队列
    public Object OutQueue() throws Exception{
        if (this.queue.front.next == null)
            throw new Exception("当前队列为空，出队失败");
        Node node = this.queue.front.next;
        this.queue.front.next = node.next;
        return node.data;
    }
    //队头元素
    public Object FrontQueue() throws Exception {
        if (this.queue.front.next == null)
            throw new Exception("当前队列为空，出队失败");
        return this.queue.front.next.data;
    }
    //判空
    public boolean EmptyQueue(){
        return this.queue.front.next == null;
    }
    //打印
    public void display(){
        System.out.print("[");
        if (!this.EmptyQueue()){
            Node node = this.queue.front.next;
            while (node.next != null){
                System.out.print(" "+node.data+",");
                node = node.next;
            }
            System.out.print(" "+node.data);
        }
        System.out.print("]\n");
    }
}
