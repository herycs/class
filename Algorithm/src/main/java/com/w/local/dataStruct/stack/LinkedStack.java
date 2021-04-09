package com.w.local.dataStruct.stack;

/**
 * @ClassNameLinkedStack
 * @Description
 * @Author ANGLE0
 * @Date 2019/12/22 13:27
 * @Version V1.0
 **/
public class LinkedStack {

    class Node {
        Object data;
        Node next;

        public Node() {
        }

        public Node(Object data) {
            this.data = data;
        }
    }

    private int size;
    private Node top;

    public LinkedStack() {
    }

    public LinkedStack(Object newData) {
        Node node = new Node(newData);
        node.next = this.top;
        this.top= node;
        size++;
    }

    //初始化栈
    public void InitStack() {
        top.data = null;
        top.next = null;
        int size = 0;
    }

    //判空
    public boolean IsEmpty() {
        return this.size() == 0;
    }

    //链栈的长度
    public int size() {
        return size;
    }

    //入栈
    public void Push(Object data) throws Exception {
        Node node = new Node(data);
        if (node == null)
            throw new Exception("节点创建失败，入栈失败");
        node.next = this.top;
        this.top = node;
        size++;
    }

    //出栈
    public Object Pop() throws Exception {
        if (this.top.next == null)
            throw new Exception("栈已空，出栈失败");
        Node node = this.top;
        this.top = node.next;
        this.size--;
        return node.data;
    }

    //获取栈顶元素
    public Object GetTop() {
        return this.top.data;
    }

    //置空栈
    public void SetEmpty() {
        this.top.next = null;
        this.top.data = null;
        size = 0;
    }

    //打印栈内元素
    public void display() throws Exception {
        System.out.print("[");
        if (!this.IsEmpty()) {
            Node node = this.top;
            while (node.next != null) {
                System.out.print(" " + node.data + ",");
                node = node.next;
            }
            System.out.print(" " + node.data);
        }
        System.out.print("]\n");
    }
}
