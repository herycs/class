package com.w.practise.forOffer;

/**
 * @ClassName Main36
 * @Description [二叉树与双向链表]
 * @Author ANGLE0
 * @Date 2020/7/28 15:26
 * @Version V1.0
 **/
public class Main36 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node head = null;// 头结点，指向整个双向链表的节点
    public Node pre = null;// 滞后指针，指向的是 curr 结点刚刚走过的节点

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        head.right = pre;
        pre.left = head;
        return head;
    }

    public void transformation(Node curr) {
        if (curr == null) return;
        transformation(curr.left);
        if (pre != null) {
            pre.right = curr;
        } else {
            head = curr;
        }
        curr.left = pre;

        pre = curr;
        transformation(curr.right);
    }
}
