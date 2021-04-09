package com.w.exam.demo15;

import java.util.Scanner;

/**
 * @ClassName Main4
 * @Description [刷子刷模板，出现断层则刷次数+1，求最少用多少次刷完木板]
 * @Author ANGLE0
 * @Date 2020/8/23 20:37
 * @Version V1.0
 **/
public class Main4 {
    public static long paintOne(int[] nums) {
        long count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
//            System.out.println(i);
            if (nums[i] >= 1 && nums[i] > nums[i + 1]) {
//                System.out.println("i =" + i);
                count++;
            }
            nums[i]--;
        }
        if (nums.length >= 2 && (nums[nums.length - 2] < nums[nums.length - 1])) count++;
        return count == 0 ? 1 : count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];

            int max = 0;
            for (int i = 0; i < n; i++) {
                int temp = scanner.nextInt();
                max = Math.max(max, temp);
                nums[i] = temp;
            }

            long count = 0;
            while (max-- > 0) {
                count += paintOne(nums);
            }
            System.out.println(count - 1);
        }
    }
}
/*
5
2 2 1 2 1

3

2
2 2

2
 */
