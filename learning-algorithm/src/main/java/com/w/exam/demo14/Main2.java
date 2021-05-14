package com.w.exam.demo14;

import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description [旋转填充数字]
 * @Author ANGLE0
 * @Date 2020/8/23 17:09
 * @Version V1.0
 **/
public class Main2 {
    public static int[][] field(int n) {
        if (n < 1 || n > 20) return null;
        int[][] nums = new int[n][n];
        int rows = n;
        int cols = n;
        // 左右上下界限
        int left = 0;
        int right = nums[0].length - 1;
        int top = 0;
        int bottom = nums.length - 1;

        int start = 1;
        while (left <= right || top <= bottom) {
            // 右
            for (int i = top; i <= bottom; i++) {
//                System.out.println("i = " + i);
                nums[i][right] = start++;
            }
            right--;
            // 下
            for (int i = right; i >= left; i--) {
                nums[bottom][i] = start++;
            }
            bottom--;

            // 左
            for (int i = bottom; i >= top; i--) {
                nums[i][left] = start++;
            }
            left++;

            // 上
            for (int i = left; i <= right; i++) {
                nums[top][i] = start++;
            }
            top++;
        }
        return nums;
    }
    public static void print(int[][] p) {
        for (int i = 0; i < p.length - 1; i++) {
            for (int j = 0; j < p[0].length; j++) {
                System.out.printf("%4d ", p[i][j]);
            }
            System.out.printf("\n");
        }
        for (int i = 0; i < p[0].length - 1; i++) {
            System.out.printf("%4d ", p[p.length - 1][i]);
        }
        System.out.printf("%4d\n", p[p.length - 1][p[0].length - 1]);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] res = field(n);
            if (res != null ) print(res);
            else System.out.println("error");
        }
    }
}
/*
3
|||d|
   7    8    1
   6    9    2
   5    4    3
 */