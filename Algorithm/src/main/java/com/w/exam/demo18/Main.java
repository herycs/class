package com.w.exam.demo18;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description [中兴]
 * @Author ANGLE0
 * @Date 2020/8/27 10:00
 * @Version V1.0
 **/
public class Main {

    public static long getMaxSum(int[][] dp) {
        if (dp.length < 3 || dp.length > 1000 || dp[0].length < 3 || dp[0].length > 1000) return 0;
        long max = 0;
        for (int i = 1; i < dp.length - 1; i++) {
            for (int j = 1; j < dp[0].length - 1; j++) {
                int curr = dp[i][j];
                int top = dp[i - 1][j];
                int left = dp[i][j - 1];
                int right = dp[i][j + 1];
                int bottom = dp[i + 1][j];
                if (curr == top && curr == left && curr == right && curr == bottom) {
                    max = Math.max(max, 5 * curr);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] dp = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] line = scanner.nextLine().split(" ");
                for (int j = 0; j < m; j++) {
                    dp[i][j] = scanner.nextInt();
                }
            }
            System.out.println(getMaxSum(dp));
        }
    }
}
/*
3 3
9 1 9
1 1 1
9 1 9

3 3
9 9 9
8 8 8
7 7 7

3 3
9 1 9
1 1 1
9 3 9

5 5
9 1 9 9 9
9 9 9 9 9
9 10 9 9 8
10 10 10 9 7
7 10 7 9 6

5
 */
