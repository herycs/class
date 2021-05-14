package com.w.practise.leetcode.practise;

import java.util.Arrays;

/**
 * @ClassName findSameNum
 * @Description [查找重复数]
 * @Author ANGLE0
 * @Date 2020/5/7 21:55
 * @Version V1.0
 **/
public class findSameNum {
    //找出数组中的重复数
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]){
                return nums[i];
            }
        }
        return -1;
    }
}
