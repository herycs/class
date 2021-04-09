package com.w.exam.demo6;

import com.w.local.dataStruct.queue.LinkedQueue;

import java.util.*;

/**
 * @ClassName Main2
 * @Description [S T 字典序最小，最长子序列]
 * @Author ANGLE0
 * @Date 2020/8/8 15:03
 * @Version V1.0
 **/
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int m = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int[] nums = new int[m];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int temp = scanner.nextInt();
            min = Math.min(temp, min);
            max = Math.max(temp, max);
            list.add(temp);
            nums[i] = temp;
        }

        int count = max - min + 1;

        if (count !=  n) {
            min = min - (n - count);
        }
        if (min <= 0) min = 1;

        int[] ns = new int[n - m];
        int mm = min;
        for (int i = 0; i < ns.length; i++) {
            if (!list.contains(mm)) {
                ns[i] = mm++;
            }
        }

        int[] res = new int[n];
        int left = 0;
        int right = 0;
        int index = 0;
        while (left < n - m && right < m) {
            res[index++] = Math.min(ns[left++], list.get(right++));
        }
        for (int s : res) {
            System.out.print(s + " ");
        }
    }
}
