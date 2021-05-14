package com.w.exam.demo13;

import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description [检查合法用户名]
 * @Author ANGLE0
 * @Date 2020/8/22 16:34
 * @Version V1.0
 **/
public class Main1 {
    public static boolean checkUsername(String s) {
        if (s == null || s.length() < 2) return false;
        char[] chars = s.toCharArray();

        boolean hasDigit = false;
        boolean hasLetter = false;

        if (Character.isLetter(chars[0])) {
            for (int i = 1; i < chars.length; i++) {
                if (Character.isDigit(chars[i])) hasDigit = true;
                else if (Character.isLetter(chars[i])) hasLetter = true;
                else break;
//                System.out.println(chars[i] + "-" + hasDigit + "-" + hasLetter);
                if (i == chars.length - 1) return hasDigit && hasLetter;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- >= 0) {
            String line = scanner.nextLine();
//                System.out.println(line);
            if (checkUsername(line))
                System.out.println("Accept");
            else
                System.out.println("Wrong");
        }
//        }
    }
}

/*
5
Ooook
Hhhh666
ABCD
Meituan
6666

 */