package com.w.exam.demo23;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Main4
 * @Description [中位数]
 * @Author ANGLE0
 * @Date 2020/9/6 21:43
 * @Version V1.0
 **/
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = scanner.nextInt();
            }
            int[] copyNums = Arrays.copyOf(nums, nums.length);
            Arrays.sort(copyNums);
            int right = copyNums[n / 2];
            int left = copyNums[(n - 1) / 2];
            System.out.println(left + "-" + right);
            for (int i = 0; i < n; i++) {
                if (nums[i] >= right)
                    System.out.println(left);
                else
                    System.out.println(right);
            }
        }
    }
}
/*
6
1 2 3 4 5 6

4
4
4
3
3
3

6
10 15 13 2 6 1

2 6 10 13 15

6
6
6
10
10
 */
