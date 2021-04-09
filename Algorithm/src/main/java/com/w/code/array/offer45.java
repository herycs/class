package com.w.code.array;

import java.util.Arrays;

/**
 * @ClassName offer45
 * @Description [数组排列成最小数字]
 * @Author ANGLE0
 * @Date 2020/7/18 16:25
 * @Version V1.0
 **/
public class offer45 {
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] str = new String[nums.length];
        for (int i = 0; i < str.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, (a, b)->((a + b).compareTo(b + a)));
        StringBuilder builder = new StringBuilder();
        for (String s : str){
            builder.append(s);
        }
        return builder.toString();
    }
}
