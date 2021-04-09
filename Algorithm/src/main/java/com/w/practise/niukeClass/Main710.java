package com.w.practise.niukeClass;

import java.util.Scanner;

/**
 * @ClassName Main7_10
 * @Description [最小编辑代价]
 * @Author ANGLE0
 * @Date 2020/7/31 11:32
 * @Version V1.0
 **/
public class Main710 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        char[] st1 = in.nextLine().toCharArray();
        char[] st2 = in.nextLine().toCharArray();

        int ic = in.nextInt();
        int dc = in.nextInt();
        int rc = in.nextInt();

        System.out.println(minEditCost(st1, st2, ic, dc, rc));
    }

    public static int minEditCost(char[] st1, char[] st2, int ic, int dc, int rc) {
        if (st1 == null || st1.length == 0 || st2 == null || st2.length == 0) return -1;

        int n = st1.length + 1;
        int m = st2.length + 1;

        int[][] dp = new int[n][m];
        // 第一列
        for (int i = 0; i < n; i++){
            dp[i][0] = dc * i;
        }
        // 第一行
        for (int j = 0; j < m; j++) {
            dp[0][j] = ic * j;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int p1 = 0;
                int p2 = 0;
                int p3 = 0;
                // st1 最后一个 -》 st2 最后一个
                // {细节：由于此时的 i , j分别表示去的字符个数，故作为索引时要 - 1,但表示的还是去i，j个字符}
                p1 = (st1[i - 1] == st2[j - 1] ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + rc);
                // st1 删去一个字符-》搞定 st2
                p2 = dp[i][j -1] + ic;
                // st1 增加一个字符-》搞定 st2
                p3 = dp[i - 1][j] + dc;

                dp[i][j] = Math.min(p1, Math.min(p2, p3));
            }
        }
        return dp[n - 1][m - 1];
    }
}
