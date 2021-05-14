package com.w.exam.demo9;

import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description [填充数组]
 * @Author ANGLE0
 * @Date 2020/8/14 19:28
 * @Version V1.0
 **/
public class Main1 {
    public static long getAns(int[][] nums, int max, int d) {
        long count = 0;
        int n = nums.length;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = max - nums[i][j];
                if (temp % d == 0){
                    count +=  temp / d;
                } else {
                    break;
                }
                if (i == n -1 && j == n - 1) flag = true;
            }
        }
        return flag ? count : -1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int d = in.nextInt();
            int[][] nums = new int[n][n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    nums[i][j] = in.nextInt();
                    max = Math.max(max, nums[i][j]);
                }
            }
            System.out.println(getAns(nums, max, d));
        }
    }
}
/*

2 1
1 2
3 4

6

2 2
1 2
3 4

-1

2 2
2 4
8 16

17
 */
