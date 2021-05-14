package com.w.exam.demo1;

/**
 * @ClassName Main6
 * @Description [S中的最长无重复子串长度]
 * @Author ANGLE0
 * @Date 2020/7/15 20:57
 * @Version V1.0
 **/
public class Main6 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int res = 0;
        int index = 0;
        for (int i = 0; i < s.length() - 1; i++){
            index = i;
            while (s.charAt(i) != s.charAt(i + 1))
                i++;
            res = Math.max(res, i - index);
        }
        return res;
    }
}
