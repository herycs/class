package com.w.practise.leetcode.practise;

/**
 * @ClassName filpString
 * @Description [翻转字符串]
 * @Author ANGLE0
 * @Date 2020/5/9 12:03
 * @Version V1.0
 **/
public class filpString {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;
        while (start < end){
            if (start > end){
                break;
            }
            if (start < s.length && end > 0){
                swap(s, start, end);
            }
        }
    }

    public static void swap(char[] chars, int i, int j){
        char s = chars[i];
        chars[i] = chars[j];
        chars[j] = chars[i];
    }
}
