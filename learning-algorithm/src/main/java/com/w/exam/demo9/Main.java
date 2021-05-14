package com.w.exam.demo9;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description [alibaba]
 * @Author ANGLE0
 * @Date 2020/8/14 17:22
 * @Version V1.0
 **/
public class Main {

    public static int MOD = 1000000007;

    public static int getLen(int n) {
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    public static long getSolution(int num) {
        long count = 0;
        int len = getLen(num);//获取数字位数

        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = num % 10;
            num /= 10;
        }

        int[] res = new int[len - 1];
        int index = 0;
        for (int i = 0; i < len - 1; i++) {
            int p1 = Math.min(nums[i], 9 - nums[i + 1]);
            int p2 = Math.min(9 - nums[i], nums[i + 1]);
            res[index++] = p1 + p2;
        }

        int temp1 = 1;
        int temp2 = 1;
        for (int i = 0; i < res.length; i++) {
            if (i % 2 == 0) {
                temp1 *= res[i] > 0 ? res[i] : 1;
            } else {
                temp2 *= res[i] > 0 ? res[i] : 1;
                count += res[i] > 0 ? res[i] : 1;
            }
        }

        return (count + temp1 + temp2) % MOD;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                System.out.println(getSolution(nums[i]));
            }
        }
    }
}