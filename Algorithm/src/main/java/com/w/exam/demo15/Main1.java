package com.w.exam.demo15;

import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description [单链表删除第k个结点]
 * @Author ANGLE0
 * @Date 2020/8/23 20:02
 * @Version V1.0
 **/
public class Main1 {
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void deleteNode(Node head, int k) {
        Node curr = head;
        Node pre = head;
        while (--k > 0) {
            pre = curr;
            curr = curr.next;
        }
        pre.next = curr.next;
        return;
    }

    public static void print(Node root) {
        if (root == null) return;
        Node temp = root;
        while (temp.next != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int n = scanner.nextInt();
            int target = scanner.nextInt();

            Node head = new Node(scanner.nextInt());
            Node temp = head;
            while (--n > 0) {
                Node curr = new Node(scanner.nextInt());
                curr.next = null;
                temp.next = curr;
                temp = curr;
            }
//            print(head);
            deleteNode(head, target);
            print(head);
        }
    }
}
/*


1 2 4 5
 */
