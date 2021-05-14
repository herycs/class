package com.w.exam.demo1;

import java.util.Scanner;

public class Main {

    private static boolean FLAG_HAS_DIGIT = false;
    private static boolean FLAG_HAS_CHAR = false;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //鉴别字符
        String password = in.nextLine();

        String res = (check(password.toCharArray()) && FLAG_HAS_DIGIT && FLAG_HAS_CHAR ? "YES" : "NO");
        System.out.print(res);
    }

    public static boolean check(char[] chars){
        if (chars.length < 8) return false;

        if (Character.isDigit(chars[0])) return false;
        int len = chars.length - 1;
        for (int i = 1; i < chars.length; i++) {
            if (i != len && !isRightChar(chars[i])){
                return false;
            }
        }
        return true;
    }

    public static boolean isRightChar(char c){
        if (Character.isDigit(c)){
            FLAG_HAS_DIGIT = true;
            return true;
        }

        if (Character.isLetter(c)){
            FLAG_HAS_CHAR = true;
            return true;
        }
        return false;
    }

    /**
     * 要求：大写， 小写， 数字（至少两种，数字不可开头，长度至少为8）
     * */

}
