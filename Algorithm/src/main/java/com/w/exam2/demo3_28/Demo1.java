package com.w.exam2.demo3_28;

import java.util.Scanner;

/**
 * @ClassName Demo1
 * @Description [数值运算]
 * @Author ANGLE0
 * @Date 2021/3/28 19:48
 * @Version V1.0
 **/
public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int total = Integer.parseInt(scanner.nextLine());

            String[] scores = scanner.nextLine().split(" ");
            long[] scoreArray = new long[total];
            for (int i = 0; i < scores.length; i++) {
                scoreArray[i] = Long.parseLong(scores[i]);
            }
            System.out.println(calc(scoreArray));
        }

    }
    public static long calc(long[] nums) {
        if (nums == null || nums.length < 1) return 0;
        // 打中一个的情况
        long oneScore = 0;
        for (int i = 0; i < nums.length; i++) {
            oneScore += nums[i];
        }
        // 打中两个的情况
        long twoScore = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                twoScore += (nums[i] | nums[j]);
            }
        }
        return oneScore + twoScore;
    }
}
