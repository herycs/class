package com.w.exam2.boos2;

import com.w.local.dataStruct.queue.LinkedQueue;

import java.util.*;

/**
 * @ClassName Demo3
 * @Description [LRU]
 * @Author ANGLE0
 * @Date 2021/4/17 14:44
 * @Version V1.0
 **/
public class Demo3 {

    /*
        get: hash 提供O1的 取值操作
        put: 采用moveToHead 完成节点向头部的迁移

        其他需要考虑的问题：
        1.最近做多使用的判定条件
            频次使用1次作为统计次数还是使用优先级队列进行排队
        2.并发情况下结构的安全性
            使用 加锁 和 private 确保公开方法的线程安全和非公开方法的隐藏

     */

    class Node {
        public String key;
        public int val;
        public Node pre;
        public Node next;

        public Node(int val) {
            this.val = val;
        }

    }


    private int size = 0;

    private int cap = 0;
    
    private Node head = null;
    
    private Node end = null;

    private ArrayList list;

    private HashMap<String, Node> doc;

    public Demo3 (int cap) {
        this.cap = cap;
        list = new ArrayList();
        doc = new HashMap<>();
        head = new Node(0);
        head.next = end;
        end.pre = head;
    }

    public void put(String key, int value) {

        if (doc.containsKey(key)) {
            moveToHead(doc.get(key));
            return;
        }

        Node node = new Node(value);
        if (size < cap) {
            list.add(node);
        } else {
            moveToHead(node);
        }
        size++;
    }

    public int get(String key) {
        return Optional.ofNullable(doc.get(key).val).orElse(-1);
    }

    private void moveToHead(Node node) {
        Node curr = doc.get(node.key);
        Node pre = curr.pre;
        Node next = curr.next;
        
        pre.next = next;
        next.pre = pre;
        
        curr.next = head.next;
        head.next.pre = curr;
        head.next = curr;
        curr.next = pre;
        
    }




}
