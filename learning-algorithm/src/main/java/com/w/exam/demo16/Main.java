package com.w.exam.demo16;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description [完美世界]
 * @Author ANGLE0
 * @Date 2020/8/25 20:08
 * @Version V1.0
 **/
public class Main {

    public static long method2(int knapsackCapacity, int[] volumes, int[] values) {
        int n = volumes.length;
        int m = knapsackCapacity;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j],
                        (j - volumes[i - 1] >= 0 ? dp[i - 1][j - volumes[i - 1]] + values[i - 1] : 0));
            }
            print(dp);
        }
        return dp[n][m];
    }

    public static long dfs(int knapsackCapacity, int[] volumes, int[] values, int temp, int index) {
        if (knapsackCapacity < 0) return 0;
        if (index == volumes.length) return temp;
        long p1 = dfs(knapsackCapacity, volumes, values, temp, index + 1);
        long p2 = dfs(knapsackCapacity - volumes[index], volumes, values, temp + values[index], index + 1);
        return Math.max(p1, p2);
    }
    public static long method1(int knapsackCapacity, int[] volumes, int[] values) {
        return dfs(knapsackCapacity, volumes, values, 0, 0);
    }

    public static long method(int knapsackCapacity, int[] volumes, int[] values) {
        int n = volumes.length;
        int m = knapsackCapacity;
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
//                System.out.println("当前体积" + (j - volumes[i - 1]));
                dp[i][j] = dp[i - 1][j] + (j - volumes[i - 1] >= 0 ? dp[i - 1][j] + values[i - 1] : 0);
            }
            print(dp);
        }
       return dp[n][m];
    }

    public static void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int knapsackCapacity = Integer.parseInt(input.nextLine().trim());

        String[] volumesStr = input.nextLine().split(" ");
        int[] volumes = new int[volumesStr.length];
        for (int i = 0; i < volumesStr.length; i++) {
            volumes[i] = Integer.parseInt(volumesStr[i].trim());
        }

        String[] valuesStr = input.nextLine().split(" ");
        int[] values = new int[valuesStr.length];
        for (int i = 0; i < valuesStr.length; i++) {
            values[i] = Integer.parseInt(valuesStr[i].trim());
        }

        if (volumes.length == values.length) {
            System.out.println(method2(knapsackCapacity, volumes, values));
        } else {
            System.out.println("道具数量不一致。");
        }
        input.close();
    }
/*
15
5 3 4 6
20 10 12 30
 */
}
