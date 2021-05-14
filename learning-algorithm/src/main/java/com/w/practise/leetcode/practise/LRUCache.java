package com.w.practise.leetcode.practise;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName LRU
 * @Description [lru算法实现，使用基础工具类]
 * @Author ANGLE0
 * @Date 2020/5/19 20:10
 * @Version V1.0
 **/
public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int limit;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.limit = capacity;
    }

    public int get(int key) {
        return getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > limit;
    }

}

/**
 * Title： [双端链表实现]
 *
 * DESC: [ 双端链表+HashTable ]
 *
 * Time: O( 1 )
 * Space: O( capt )
 *
 */
class Lru2 {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private void addNode(DLinkedNode node) {
        /**修改策略：
         * 总是添加到队头
         * 首先节点入链表：修改节点指针，node.prev->head, node.next->head.next
         * 链表调整：修改原始链表中指针，head.next.prev->node（先执行这步，避免next修改后操作不便）, head.next->node
         */
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        /**
         * Remove an existing node from the linked list.
         */
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node) {
        /**
         * 移动到对头，策略:删除再添加
         */
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        /**
         * Pop the current tail.
         */
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public Lru2(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        // head.prev = null;

        tail = new DLinkedNode();
        // tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        // move the accessed node to the head;
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        //获取key对应的节点，非空则更新
        DLinkedNode node = cache.get(key);
        //节点为空则添加节点
        if (node == null) {
            //创建节点元素
            DLinkedNode newNode = new DLinkedNode();
            newNode.value = value;
            newNode.key = key;

            //节点入链表
            addNode(newNode);

            //更新数据个数
            size++;

            if (size > capacity) {
                DLinkedNode temp = popTail();
                cache.remove(temp.key);
                size--;
            }
            //溢出，则删除节点
        } else {
            //更新
            node.value = value;
            moveToHead(node);
        }
    }
}
