package com.w.practise.leetcode.huawei;

import com.w.local.dataStruct.queue.LinkedQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Main143
 * @Description [重排链表，给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…]
 * @Author ANGLE0
 * @Date 2020/8/27 17:48
 * @Version V1.0
 **/
public class Main143 {
      // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

      /*
           持续需要倒序的值，需要存储值或者能遍历到值
             针对倒序值问题：
                1.数组（需要设置扩容方法），
                2.链表，空间占用比较大，
                3.栈或者队列辅助设置,
                4.链表拆分成两部分，倒序合并（快慢指针）

             最佳实践，链表拆分
             当前实践，队列
       */

    /**
       * { 队列维护链表节点 }
       * Time: O( N )
       * Space: O( N )
       *
       */
    public void reorderList1(ListNode head) {
          if (head == null) return;

        LinkedList<ListNode> list = new LinkedList<>();
        ListNode curr = head.next;
        while (curr != null) { // head.next ... last of list
            list.addLast(curr);
            curr = curr.next;
        }
        curr = head;
        boolean pollLast = true;
        ListNode temp = null;
        while (!list.isEmpty()) {
            if (pollLast) {
                System.out.println("last");
                temp = list.pollLast();
                pollLast = false;
            } else {
                System.out.println("first");
                temp = list.pollFirst();
                pollLast = true;
            }
            System.out.println(temp.val);
            if (temp != null) {
                temp.next = null;
                curr.next = temp;
                curr = curr.next;
            }
        }
    }

    /**
     * { 链表拆分再重组 }
     */
    public void reorderList(ListNode head) {
        if (head == null || head == null || head.next == null ) return;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != null) fast = fast.next; // 捕获最后一个节点
        // 倒置链表

        ListNode curr = slow.next;// 拿到后一段链表的开始，第 n / 2 个节点
        slow.next = null; // 结束前一段链表， 0 -> 1 -> 2 -> n / 2

        ListNode next = curr.next;
        ListNode pre = null;
        while (curr != null) {
            curr.next = pre;
            pre = curr;
            curr = next;
            if (next != null) next = next.next;
        }

        ListNode h = head.next;
        ListNode temp = head;
        while (h != null) {
            ListNode secondNode = h;
            h = h.next;
            ListNode firstNode = pre;
            pre = pre.next;

            firstNode.next = secondNode;
            secondNode.next = null;
            temp.next = firstNode;
            temp = secondNode;
        }
        if (pre != null) {
            pre.next = null;
            temp.next = pre;
        }
    }

    public ListNode reserve(ListNode list) {
        if (list == null) return null;
        ListNode curr = list;
        ListNode next = list;
        ListNode pre=  null;
        while (curr != null) {
            curr.next = pre;
            pre = curr;
            curr = next;
            next = next.next;
        }
        return list;
    }
}
