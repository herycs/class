package com.w.local.dataStruct.linearList;

import com.w.local.dataStruct.linearList.link.MyLinkedList;
import com.w.local.dataStruct.linearList.sequence.MyArrayList;

/**
 * @ClassNameTest
 * @Description
 * @Author ANGLE0
 * @Date 2019/12/21 15:46
 * @Version V1.0
 **/
public class Test {

    public static void main(String[] args) throws Exception {
        LinkedListTest();
    }

    private static void LinkedListTest() throws Exception {
        MyLinkedList myLinkedList = new MyLinkedList(0);
        for (int i = 0; i < 10; i++) {
            myLinkedList.insert(i, i);
        }
        System.out.println("建立链表如下：");
        myLinkedList.display();
        System.out.println("索引为1处插入数值9");
        myLinkedList.insert(1, 9);
        myLinkedList.display();
        System.out.println("移除索引为3的节点");
        myLinkedList.remove(3);
        myLinkedList.display();
        System.out.println("清除链表");
        myLinkedList.clear();
        myLinkedList.display();
    }

    private static void SeqListTest() throws Exception {
        MyArrayList L = new MyArrayList(10);
        for (int i = 0; i < 8; i++)
            L.insert(i, i);
        System.out.println("删除索引为1的元素");
        L.remove(1);
        L.display();
        System.out.println("索引为3处插入元素");
        L.insert(3, 5);
        L.display();
        System.out.println("获取索引为1的元素值");
        System.out.println(L.get(1));
    }

}
