package com.w.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * @ClassName test
 * @Description []
 * @Author ANGLE0
 * @Date 2020/7/23 10:14
 * @Version V1.0
 **/
public class test {

    static class Node{
        public int a;

        public Node(int a) {
            this.a = a;
        }
    }

    public static void main(String[] args) {
        Comparator comparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.a - o1.a;
            }
        };

        Node[] nums = new Node[3];
        nums[0] = new Node(1);
        nums[1] = new Node(3);
        nums[2] = new Node(4);

        Arrays.sort(nums, comparator);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i].a);
        }
    }

}
