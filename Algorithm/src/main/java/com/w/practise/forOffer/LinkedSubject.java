package com.w.practise.forOffer;

/**
 * @ClassName LinkedSubject
 * @Description [链表类型题目]
 * @Author ANGLE0
 * @Date 2020/5/22 11:30
 * @Version V1.0
 **/
public class LinkedSubject {

    //节点定义
    class Node1 {
        int data;
        Node1 next;
    }

    //查找倒数第k个结点
    public Node1 getLastKNodeFromList(Node1 root, int k) {
        //1.判空
        if (root == null || k < 0) return null;
        //2.非空
        Node1 preNode = root;
        Node1 behindNode = root;

        //后一个结点指针指向第k-1个结点
        for (int i = 0; i < k-1; i++) {
            if (root.next != null) {
                behindNode = root.next;
            } else {
                return null;
            }
        }

        //节点并行
        while (behindNode.next != null){
            preNode = preNode.next;
            behindNode = behindNode.next;
        }

        //3.返回结果
        return preNode;
    }
}
