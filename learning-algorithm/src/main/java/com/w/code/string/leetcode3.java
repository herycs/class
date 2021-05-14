package com.w.code.string;

import java.util.HashMap;

/**
 * @ClassName leetcode3
 * @Description [最长无重复子串]
 * @Author ANGLE0
 * @Date 2020/7/18 15:39
 * @Version V1.0
 **/
public class leetcode3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = -1; i < s.length(); i++) {//其中j为左边界，i为右边界
            if (map.containsKey(s.charAt(i)))
                j = Math.max(j, map.get(s.charAt(i)));
            map.put(s.charAt(i), i);
            res = Math.max(res, (i - j));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
