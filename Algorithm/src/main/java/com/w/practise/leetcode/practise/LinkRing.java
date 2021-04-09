package com.w.practise.leetcode.practise;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LinkRing
 * @Description [链表是否成环]
 * @Author ANGLE0
 * @Date 2020/5/7 21:20
 * @Version V1.0
 **/
public class LinkRing {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //一个一步走，一个两步走，一旦相遇则成环，否则无环
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode firstPos = head;
        ListNode secondPos = head.next;
        while (secondPos != firstPos) {
            if (secondPos.next == null || secondPos.next.next == null) {
                return false;
            }
            firstPos = firstPos.next;
            secondPos = secondPos.next.next;
        }
        return true;
    }

    //记录走过的，不断查找是否遇到过，若有则成环，否则无环
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * DES：
     * [返回链表中入环的第一个节点，无环则输出null]
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> sets = new HashSet<ListNode>();

        ListNode node = head;
        while (node != null) {
            if (sets.contains(node)) {
                return node;
            }
            sets.add(node);
            node = node.next;
        }

        return null;
    }
}
