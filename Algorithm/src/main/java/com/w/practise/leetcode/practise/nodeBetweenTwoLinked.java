package com.w.practise.leetcode.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName nodeBetweenTwoLinked
 * @Description [两个链表的相交节点的起始节点]
 * @Author ANGLE0
 * @Date 2020/5/13 14:49
 * @Version V1.0
 **/
public class nodeBetweenTwoLinked {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map map = new HashMap();
        ListNode pos1 = headA;
        ListNode pos2 = headB;
        if (pos1 == null || pos2 == null) return null;
        while (pos1 != null) {
            map.put(pos1.val, headA);
            pos1 = pos1.next;
        }
        while (pos2 != null) {
            if (map.containsValue(pos2)) {
                return pos2;
            }
        }
        return null;
    }
}
