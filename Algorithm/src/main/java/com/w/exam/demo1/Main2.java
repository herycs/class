package com.w.exam.demo1;

import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description [k个结点一反转]
 * @Author ANGLE0
 * @Date 2020/7/15 19:27
 * @Version V1.0
 **/
public class Main2 {

    static int k = 0;
    static class Node{
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        k = in.nextInt();
        //构建链表
        Node head = new Node(-1);
        head.next = null;

        Node pres = head;
        while (in.hasNextInt()) {
            Node temp = new Node(in.nextInt());
            temp.next = null;

            pres.next = temp;
            pres = temp;
        }
        pres.next = null;

        //控制反转过程
        Node pre = head;
        Node next = null;
        Node start = null;
        Node end = head.next;

        int count = 0;
        while (end != null && end.next != null) {
            count = k;
            while (end != null && count != 0) {
                end = end.next;
                --count;
            }
            //区间结束
            next = end.next;
            start = pre.next;
            pre.next = reserve(start);
            start.next = end;
            pre = start;
        }

        print(head.next);
    }

    public static Node reserve(Node head){

        if (head == null) return null;

        Node pre = null;
        Node curr = head;
        Node temp = null;
        while (curr != null){
            temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public static void print(Node head){
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

//    public void com.w.test(){
//        Node head = new Node(0);
//        Node pre = head;
//        for (int i = 0; i < 10; i++) {
//            Node temp = new Node(i);
//            temp.next = null;
//            pre.next = temp;
//            pre = pre.next;
//        }
//        head = reserve(head);
//        print(head);
//    }
}
