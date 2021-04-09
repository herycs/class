package com.w.practise.niukeClass;

import java.util.Scanner;

/**
 * @ClassName Main61
 * @Description [牛牛背包问题]
 * @Author ANGLE0
 * @Date 2020/7/29 7:53
 * @Version V1.0
 **/
public class Main61 {

    public static int getPath(int[] arr, int index, int rest){
        if (rest < 0) return -1;
        if (index == arr.length) return 1;
        //选择
        int path1 = getPath(arr, index + 1, rest);// no
        int path2 = getPath(arr, index + 1, rest - arr[index]);
        return path1 + (path2 != -1 ? 0 : path2);
    }

    public static int getPath(int[] arr, int rest) {
        int[][] dp = new int[arr.length + 1][rest + 1];
        for (int i = 0; i <= rest; i++) {
            dp[arr.length][i] = 1;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j <= rest; j++) {
                dp[i][j] = dp[i + 1][j] + ((j - arr[i]) >= 0 ? dp[i + 1][j - arr[i]] : 0);
            }
        }
        return dp[0][rest];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int v = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            System.out.println(getPath(nums, v));
        }
    }
}
