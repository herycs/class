package com.w.practise.company.wy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName WY3
 * @Description [升级之路]
 * @Author ANGLE0
 * @Date 2020/8/10 10:33
 * @Version V1.0
 **/
public class WY3 {
    public static int getMaxSubNum(int a, int b) {
        int temp = a % b;
        while (temp != 0) {
            a = b;
            b = temp;
            temp = a % b;
        }
        return b;
    }

    public static int getLastAbility(int[] nums, int a) {
        for (int i = 0; i < nums.length; i++) {
            if (a < nums[i]) {
                a += getMaxSubNum(a, nums[i]);
            } else {
                a += nums[i];
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int a = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = in.nextInt();
            }
            System.out.println(getLastAbility(nums, a));
        }
    }
}

/*
3 50
50 105 200
5 20
30 20 15 40 100

110
205
 */
