package com.w.practise.leetcode.practise;

/**
 * @ClassName strStr
 * @Description [模式匹配]
 * @Author ANGLE0
 * @Date 2020/5/5 21:14
 * @Version V1.0
 **/
public class strStr {
    public int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();

        for (int start = 0; start < n - L + 1; ++start) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }
}
