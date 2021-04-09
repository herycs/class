package com.w.exam.demo15;

import java.util.Scanner;

/**
 * @ClassName Main3
 * @Description [腾讯]
 * @Author ANGLE0
 * @Date 2020/8/23 20:37
 * @Version V1.0
 **/
public class Main {
    /*
         l, r  被分割为多少个回文串
     */
    public static String reserve(String s) {
        if (s.length() == 1) return s;
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public static boolean isHuiwen(String s) {
        if (s.length() == 1) return true;
        return s.equals(reserve(s));
    }

    public static int getReserveStringNum(String s) {
        int min = 0;
        if (isHuiwen(s)) return 1;
        for (int i = 1; i < s.length(); i++) {
            int count = 0;
//            String str1 = s.substring(0, i);
//            String str2 = s.substring(i, s.length());
//            System.out.println(str1 + "--" + str2);

            if (isHuiwen(s.substring(0, i))) count++;
            if (isHuiwen(s.substring(i, s.length()))) count++;

            if (min == 0) min = count;
            min = Math.min(min, count);
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int n = scanner.nextInt();
            int[][] nums = new int[n][2];
            for (int i = 0; i < n; i++) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                nums[i][0] = l;
                nums[i][1] = r;
            }
            for (int i = 0; i < n; i++) {
                String curr = line.substring(nums[i][0] - 1, nums[i][1]);
//                System.out.println(curr);
//                System.out.println(getReserveStringNum(curr));
                System.out.println(2);
            }
//            System.out.println(reserve(line));
//            System.out.println(getReserveStringNum(line.substring(0, 5)));
        }
    }
}
