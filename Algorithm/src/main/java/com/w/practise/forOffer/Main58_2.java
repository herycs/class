package com.w.practise.forOffer;

import java.util.ArrayList;

/**
 * @ClassName Main58_2
 * @Description [左旋转字符串]
 * @Author ANGLE0
 * @Date 2020/8/2 8:02
 * @Version V1.0
 **/
public class Main58_2 {
    /**
     * Title： [左旋转字符串]
     * <p>
     * DESC: [ 思路 ]
     * {
     * 1.剪切+拼接
     * 2.list存储单个字符，再按范围拼接
     * 3.字符串翻转，3次{ 0~s.len | 0~n | n ~ s.len}
     * }
     */

    // 1.
    public String reverseLeftWords1(String s, int n) {
        if (s == null || s.length() == 0 || n < 0) return s;

        String str = s.substring(0, n);
        String str2 = s.substring(n, s.length());

        return str2 + str;
    }

    // 2.
    public String reverseLeftWords2(String s, int n) {
        if (s == null || s.length() == 0 || n < 0) return s;

        ArrayList<Character> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        StringBuilder builder = new StringBuilder();

        for (int i = n; i < s.length(); i++) {
            builder.append(list.get(i));
        }

        for (int j = 0; j < n; j++) {
            builder.append(list.get(j));
        }

        return builder.toString();
    }
}
