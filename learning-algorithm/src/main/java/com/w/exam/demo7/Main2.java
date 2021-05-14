package com.w.exam.demo7;

import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description [矩阵+固定步长]
 * @Author ANGLE0
 * @Date 2020/8/12 19:05
 * @Version V1.0
 **/
public class Main2 {
    public static boolean getAns(int[][] nums, int i, int j,  int s) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length) return false;
        if (i == nums.length - 1 && j == nums[0].length - 1 && nums[i][j] == 1) return true;
        return getAns(nums, i, j + s, s) ||
                getAns(nums, i + s, j, s) ||
                getAns(nums, i, j - s, s) ||
                getAns(nums, i - s, j, s);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int s = in.nextInt();
            int m = in.nextInt();
            int n = in.nextInt();
            int[][] nums = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    nums[i][j] = in.nextInt();
                }
            }
            System.out.println(getAns(nums, 0, 0, s) ? 1 : 0);
        }
    }
}
