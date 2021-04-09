package com.w.exam.demo26;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description [最右]
 * @Author ANGLE0
 * @Date 2020/9/10 19:13
 * @Version V1.0
 **/
public class Main {
    /*
    *
    9223372036854775807
    -9223372036854775808
    * */
    public static void main(String[] args) {
//        System.out.println('a' - 87);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(isC(9223372036854775800l, 7, true));
        }
    }
    public static boolean isRight(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (!(Character.isDigit(chars[i]) || Character.isLetter(chars[i]))) {
                return false;
            }
        }
        return true;
    }

    public static long getRes(String str) {
        if (str == null || str.length() < 1) return 0l;
        boolean fu = false;

        if (str.charAt(0) == '-') {
            str = str.substring(1);
        }

        char[] cs = str.toCharArray();
        long res = 0l;
        if (fu) {
            for (int i = 0; i < cs.length; i++) {
                int val = Character.isDigit(cs[i]) ? cs[i] - 0 : cs[i] - 87;
                int temp = 16;
                long addVal = (long) (Math.pow(16, i) * val);
                if (isC(res, addVal, fu)) {
                    return Long.MIN_VALUE;
                } else {
                    res += addVal;
                }
            }
        } else {
            int carry = -1;
            for (int i = cs.length - 1; i > 0; i--) {
                int val = Character.isDigit(cs[i]) ? cs[i] - 0 : cs[i] - 87;
                int temp = 16;

                long addVal = (long) (Math.pow(16, carry--) * val);
                if (isC(res, addVal, !fu)) {
                    return Long.MAX_VALUE;
                } else {
                    res += addVal;
                }
            }
        }
        return res;
    }

    public static boolean isC(long n, long addVal, boolean fu) {
        return Long.MAX_VALUE - addVal < n;
    }
}
/*
1y2p0ij32e8e7

-sfse

 */