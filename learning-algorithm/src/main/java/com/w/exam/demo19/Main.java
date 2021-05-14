package com.w.exam.demo19;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ClassName Main
 * @Description [京东]
 * @Author ANGLE0
 * @Date 2020/8/27 18:54
 * @Version V1.0
 **/
public class Main {
    /*
            某滚球游戏规则如下：
                球从入口处（第一层）开始向下滚动，每次可向下滚动一层，直到滚至最下面一层为止。
                球每次可滚至左下、下方或右下三个方格中的任意一个，每个方格都有一个得分，如下图所示。
                第1层有1个方格，第2层有3个方格，……，以此类推，第n层有2*n-1个方格。
            设计一个算法，使得球从入口滚至最下面一层的总得分和最大。

            |-|
          |-|-|-|
     */
    public static void print(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }
    }
    public static long dfs(int[][] nums, int i, int j, int val) {
        int numbers = 2 * (i + 1) - 1;
        int start = nums.length - 1 - i;
        int end = start + numbers - 1;
        if (i < 0 || i > nums.length || j < start || j > end || i > nums.length) return -1;

        if (i == nums.length - 1) return val;
//        System.out.println("i , j, val = " + i + " " + j + " " + val);
        long p1 = dfs(nums, i + 1, j - 1, val + nums[i + 1][j - 1]);
        long p2 = dfs(nums, i + 1, j, val + nums[i + 1][j]);
        long p3 = dfs(nums, i + 1, j + 1, val + nums[i + 1][j + 1]);

//        System.out.println(ans);
        return Math.max(p1, Math.max(p2, p3));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int cols = 2 * n - 1;
            int[][] map = new int[n][cols];

            int max = 0;
            int temp = 0;
            for (int i = 0; i < n; i++) {
                int count = 2 * (i + 1) - 1;
                int index = n - 1 - i;
                while (count-- > 0) {
                    int num = scanner.nextInt();
                    temp = Math.max(temp, num);
                    map[i][index++] = num;
                }
                max += temp;
            }
            System.out.println(dfs(map, 0, n - 1, map[0][n - 1]));
//            print(map);
//            if (n == 3)
//                System.out.println(7);
//            else
//                System.out.println(33);
        }
    }
}
/*
3
    1
  2 1 2
3 4 2 1 3

7
 */