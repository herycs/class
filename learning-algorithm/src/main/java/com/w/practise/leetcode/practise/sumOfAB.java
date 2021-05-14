package com.w.practise.leetcode.practise;

/**
 * @ClassName sumOfAB
 * @Description [A+B=定值]
 * @Author ANGLE0
 * @Date 2020/5/5 14:58
 * @Version V1.0
 **/
public class sumOfAB {
    /*
        1
        DEC：
            求解A+B为定值的数据下标
     */
    public int[] twoSum(int[] nums, int target) throws IllegalAccessException {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalAccessException("No solution");
    }
}
