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
        get: hash �ṩO1�� ȡֵ����
        put: ����moveToHead ��ɽڵ���ͷ����Ǩ��

        ������Ҫ���ǵ����⣺
        1.�������ʹ�õ��ж�����
            Ƶ��ʹ��1����Ϊͳ�ƴ�������ʹ�����ȼ����н����Ŷ�
        2.��������½ṹ�İ�ȫ��
            ʹ�� ���� �� private ȷ�������������̰߳�ȫ�ͷǹ�������������

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
