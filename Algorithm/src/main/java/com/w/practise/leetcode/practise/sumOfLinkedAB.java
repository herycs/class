package com.w.practise.leetcode.practise;

/**
 * @ClassName sumOfLinkedAB
 * @Description [链表求和]
 * @Author ANGLE0
 * @Date 2020/5/5 14:59
 * @Version V1.0
 **/
public class sumOfLinkedAB {
    /*
        DES：
            AB链表求和
     */
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);

        ListNode p = l1, q = l2, list = res;
        int upNum = 0;
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;

            int sum = x + y + upNum;
            upNum = sum / 10;
            list.next = new ListNode(sum % 10);
            list = list.next;

            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }
        if (upNum > 0)
            list.next = new ListNode(upNum);
        return res.next;
    }
}
