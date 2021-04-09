package com.w.exam.demo15;

import java.util.Scanner;

/**
 * @ClassName Main3
 * @Description []
 * @Author ANGLE0
 * @Date 2020/8/23 20:37
 * @Version V1.0
 **/
public class Main3 {
    /*
         数字拆分为a b, a + b = n
      */
    public static int getSumOfNums(int n1, int n2) {
        int sum1 = 0;
        int sum2 = 0;
        while (n1 != 0) {
            sum1 += n1 % 10;
            n1 /= 10;
        }
        while (n2 != 0) {
            sum2 += n2 % 10;
            n2 /= 10;
        }
        return sum1 + sum2;
    }
    public static int getSplitNum(int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= k / 2; i++) {
            max = Math.max(max, getSumOfNums(i, k - i));
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                int k = scanner.nextInt();
                System.out.println(getSplitNum(k));
            }
//            System.out.println(getSumOfNums(19, 16));
        }
    }
}
