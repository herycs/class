package com.w.exam.demo10;

import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description [练习题1]
 * @Author ANGLE0
 * @Date 2020/8/16 18:47
 * @Version V1.0
 **/
public class Main1 {
    // 花费最小路径

    /*
4 5
0 1 15
1 2 15
0 3 50
1 3 30
2 3 10
3

20
     */

    public static int res = 0;

    public static void getMinPath(int[][] nums, int k, int temp) {
        if (k < 0) return;
        if (k == 0) {
            res = Math.min(temp, res);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i][j] != 0) {
                    getMinPath(nums, k - j, temp + nums[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            res = 40;
            int[][] nums = new int[n][n];
            for (int i = 0; i < m; i++) {
                int ii = in.nextInt();
                int j = in.nextInt();
                nums[ii][j] = in.nextInt();
            }
            int end = in.nextInt();
            getMinPath(nums, end, 0);
            res = 40;
            System.out.println(res);
        }
    }
}
