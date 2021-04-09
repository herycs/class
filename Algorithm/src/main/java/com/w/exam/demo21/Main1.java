package com.w.exam.demo21;

import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description [0, 5组合数字，整除90]
 * @Author ANGLE0
 * @Date 2020/9/3 20:19
 * @Version V1.0
 **/
public class Main1 {
    // 由 0， 5 为基础的能被90除尽的最大值
    public static long helper(int[] nums, int count_0) {
        long max = getNum(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                swap(nums, i, j);
                long temp = getNum(nums);
                if (temp % 10 == 0) {
                    long num = temp / 10;
                    if (num % 9 == 0 && num / 9 == 0) {
                        max = Math.max(max, temp);
                    }
                }
            }
        }
        return max % 10 == 0 ? max : -1;
    }
    public static void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static long getNum(int[] nums) {
        if (nums.length < 1) return 0l;
        long res = nums[0];
        int curr = 0;
        for (int i = 1; i < nums.length; i++) {
            curr = nums[i];
            res = res * 10 + curr;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            int count_0 = 0;
            for (int i = 0; i < n; i++) {
                int temp = scanner.nextInt();
                if (temp == 0) count_0++;
                nums[i] = temp;
            }

            nums[nums.length - 1] = 0;
            nums[nums.length - 2] = 5;
            for (int i = 0; i < nums.length - 2; i++) {
                nums[i] = 5;
            }
            for (int i = nums.length - 3; count_0 > 1; count_0--, i--) {
                nums[i] = 0;
            }
            System.out.println(getNum(nums));
        }
    }
}
/*

11
5 5 5 5 5 5 5 5 0 5 5

num  % 90 == 0
 */