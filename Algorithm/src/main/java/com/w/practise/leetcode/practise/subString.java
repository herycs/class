package com.w.practise.leetcode.practise;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName subString
 * @Description [最长不重复子串]
 * @Author ANGLE0
 * @Date 2020/5/5 14:59
 * @Version V1.0
 **/
public class subString {
    /*
        DES:
            求解最长不重复子串
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<Character>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
