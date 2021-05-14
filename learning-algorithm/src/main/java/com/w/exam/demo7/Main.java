package com.w.exam.demo7;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(",");
        String str = s[0];
        int len = str.length();
        int step = Integer.parseInt(s[1]) * 2 - 3;

        StringBuilder builder = new StringBuilder();
        int index = 0;
        for (int i = 0; i < step; i++) {
            index = i;
            while (index < len) {
                builder.append(str.charAt(index));
                index += step;
            }
        }
        System.out.println(builder.toString());
    }
}
/*
        E V E R Y T H I N G G  O  E  S  W  E  L  L,5
        0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17

        1             1                 1
            1     1       1       1           1
                1               1
              1     1     1           1       1
          1             1                  1

        0 7 14
        2
        E I W  E T G E  L  Y O R H G S L V N E
        0 7 14 2 5 9 12 16 3
 */