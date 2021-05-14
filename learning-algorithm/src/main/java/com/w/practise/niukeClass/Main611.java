package com.w.practise.niukeClass;

import java.util.Scanner;

/**
 * @ClassName Main611
 * @Description [最大路径和]
 * @Author ANGLE0
 * @Date 2020/8/4 11:04
 * @Version V1.0
 **/
public class Main611 {
    public static int maxSumOfPath(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) return 0;

        for (int i = 1; i < arr[0].length; i++) {
            arr[0][i] = arr[0][i] + arr[0][i - 1];
        }
        for (int i = 1; i < arr.length; i++) {
            arr[i][0] = arr[i][0] + arr[i - 1][0];
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                arr[i][j] += Math.min(arr[i - 1][j], arr[i][j - 1]);
            }
        }
        return arr[arr.length - 1][arr[0].length - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println(maxSumOfPath(arr));
    }
}
