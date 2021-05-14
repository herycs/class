package com.w.exam.demo6;

import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description [素数拆分]
 * @Author ANGLE0
 * @Date 2020/8/8 15:03
 * @Version V1.0
 **/
public class Main1 {
    private static int count = 0;

    public static void getCount(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            count += getSum(nums[i]);
        }
    }

    public static int getSum(int a) {
        int count = 0;
        if (a < 0) return 0;
        if (a == 1) return 0;
        if (a == 2 || a == 3) return 1;
        return a / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        getCount(nums);
        System.out.println(count);
    }
}
