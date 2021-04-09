package com.w.practise.niukeClass;

import java.util.Scanner;

/**
 * @ClassName Main71
 * @Description [牛牛背包问题]
 * @Author ANGLE0
 * @Date 2020/8/4 9:05
 * @Version V1.0
 **/
public class Main71 {

    /**
     * nums： 零食
     * v：剩余体积
     * */
    public static int getMethods(int[] nums, int index, int v) {
        if (v < 0) return -1;
        if (index == nums.length) return 1;
        int p1 = getMethods(nums, index + 1, v);
        int p2 = getMethods(nums, index + 1, v - nums[index]);
        return p1 + (p2 != -1 ? p2 : 0);
    }

    public static int getMethods1(int[] nums, int v) {
        int[][] dp = new int[nums.length + 1][v + 1];
        for (int i = 0; i <= v; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = nums[i - 1]; j <= v; j++) {
                dp[i][j] = dp[i - 1][j] + (dp[i - 1][j - nums[i - 1]] >= 0 ? dp[i - 1][j - nums[i - 1]] : 0);
            }
        }
//        print(dp);
        return dp[nums.length][v];
    }
    // 改动态规划
    public static int getMethods2(int[] nums, int v) {
        int[][] dp = new int[nums.length + 1][v + 1];
        for (int i = 0; i < v + 1; i++) {
            dp[nums.length][i] = 1;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums[i]; j <= v; j++) {
                dp[i][j] = dp[i + 1][j]
                        + (j - nums[i] >= 0 ? dp[i + 1][j - nums[i]] : 0);
            }
            print(dp);
        }
        return dp[0][v];
    }

    public static void print(int[][] dp){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cap = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(getMethods(nums, 0, cap));
    }

}
/*
3 10
1 2 4

8
 */
