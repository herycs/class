package com.w.practise.forOffer;

/**
 * @ClassName Main22
 * @Description [链表倒数第k个结点]
 * @Author ANGLE0
 * @Date 2020/8/2 8:11
 * @Version V1.0
 **/
public class Main22 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k < 1) return null;

        ListNode tail = head;
        while (--k > 0) {
            tail = tail.next;
        }
        ListNode target = head;
        while (tail.next != null) {
            tail = tail.next;
            target = target.next;
        }
        return target;
    }
}
