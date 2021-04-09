package com.w.local.dataStruct.linearList.link;

import com.w.local.dataStruct.linearList.MyList;

/**
 * @ClassNameMyLinkedList
 * @Description
 * @Author ANGLE0
 * @Date 2019/12/21 17:14
 * @Version V1.0
 **/
public class MyLinkedList<E> implements MyList {

    private E data;
    private MyLinkedList next;

    public MyLinkedList() {
    }

    /**
     * @Desc:  [初始化链表]
     * @param :  MyLinkedList
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 17:22
     * @version : v1.0
     */
    public MyLinkedList(Object x) {
        this.data = (E)x;
        this.next = null;
    }

    /**
     * @Desc:  [清空链表]
     * @param :  void
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 17:22
     * @version : v1.0
     */
    public void clear() {
        this.next = null;
    }

    /**
     * @Desc:  [链表是否为空]
     * @param :  void
     * @return : boolean
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 17:23
     * @version : v1.0
     */
    public boolean isEmpty() {
        return this.data == null && this.next == null;
    }

    /**
     * @Desc:  [链表长度]
     * @param :  void
     * @return : int
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 17:23
     * @version : v1.0
     */
    public int length() {
        int count = 0;
        MyLinkedList linkedList = this;
        if (linkedList != null){
            count++;
            linkedList = linkedList.next;
        }
        return count;
    }

    /**
     * @Desc:  [获取索引为i的值]
     * @param : void
     * @return : Object
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 17:26
     * @version : v1.0
     */
    public E get(int i) throws Exception {
        int count = 0;
        MyLinkedList linkedList = this;
        while (count < i){
            linkedList = linkedList.next;
        }
        return (E)linkedList.data;
    }

    /**
     * @Desc:  [插入节点，前置插入]
     * @param :  int， Object
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 18:35
     * @version : v1.0
     */
    public void insert(int i, Object x) throws Exception {
        MyLinkedList myLinkedList = this.NodePreI(i);
        //创建新元素并嵌入链表中
        MyLinkedList newNode = new MyLinkedList(x);
        newNode.next = myLinkedList.next;
        myLinkedList.next = newNode;
    }

    /**
     * @Desc:  [移除第i个节点]
     * @param :  int
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 18:39
     * @version : v1.0
     */
    public void remove(int i) throws Exception {
        MyLinkedList myLinkedList = NodePreI(i);
        myLinkedList.next = myLinkedList.next.next;
    }

    /**
     * @Desc:  [返回第i-1个节点]
     * @param :  int
     * @return : MyLinkedList
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 18:54
     * @version : v1.0
     */
    private MyLinkedList NodePreI(int i) {
        MyLinkedList myLinkedList = this;
        if (this == null)
            throw new NullPointerException("链表为空，索引"+i+"位置无效");
        if (i < 0){
            throw new NullPointerException("索引位置越界，索引"+i+"无效");
        }
        //遍历到第i个节点前一个节点
        for (int j = 0; j < i-1; j++) {
            myLinkedList = myLinkedList.next;
        }
        return myLinkedList;
    }

    /**
     * @Desc:  [查找出第一个值为x的索引位置]
     * @param :  Object
     * @return : int -1代表查询无结果
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 18:40
     * @version : v1.0
     */
    public int indexOf(Object x) {
        MyLinkedList myLinkedList = this;
        if (this == null)
            throw new NullPointerException("链表为空，查找失败");
        MyLinkedList myLinkedList1 = this;
        int count = 0;
        while (myLinkedList1.next != null && myLinkedList1.data.equals(x)) {
            myLinkedList1 = myLinkedList1.next;
            count++;
        }
        return count > this.length() ? -1 : count;
    }

    /**
     * @Desc:  [打印当前链表的所有值]
     * @param :  void
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 18:44
     * @version : v1.0
     */
    public void display() {
        MyLinkedList myLinkedList = this;
        while (myLinkedList.next != null){
            System.out.print(myLinkedList.data + "-->");
            myLinkedList = myLinkedList.next;
        }
        System.out.print("\b\b\b   \n");
    }
}
