package com.w.practise.company.wy;

import java.util.Scanner;

/**
 * @ClassName WY5
 * @Description [扫描蘑菇]
 * @Author ANGLE0
 * @Date 2020/8/11 11:11
 * @Version V1.0
 **/
public class WY5 {

    public static void scan(int[][] nums, int[] res) {
        int rows = nums.length;
        int cols = nums[0].length;
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                int temp = 0;
                for (int k = i; k < i + 3; k++) {
                    for (int g = j; g < j + 3; g++) {
                        if (nums[k][g] > 0) {
                            temp++;
                        }
                    }
                }
                if (temp > res[0]) {
                    res[0] = temp;
                    res[1] = i;
                    res[2] = j;
                }
            }
        }
    }

    public static void clear(int[][] nums, int a, int b) {
        for (int i = a; i < a + 3; i++) {
            for (int j = b; j < b + 3; j++) {
                if (nums[i][j] > 0) {
                    nums[i][j]--;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();

            if (n < 3) n = 3;
            if (m < 3) m = 3;
            int[][] nums = new int[n][m];
            while (k-- > 0) {
                int i = in.nextInt();
                int j = in.nextInt();
                nums[i - 1][j - 1]++;
            }

            int[] res_1 = new int[3];
            int[] res_2 = new int[3];
            scan(nums, res_1);
            clear(nums, res_1[1], res_1[2]);
            scan(nums, res_2);

            System.out.println(res_1[0] + res_2[0]);
        }
    }
}
/*
3 3 3
1 2
2 3
3 3

 */