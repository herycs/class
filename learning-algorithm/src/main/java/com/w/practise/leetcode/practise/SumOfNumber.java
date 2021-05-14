package com.w.practise.leetcode.practise;

import java.util.*;

/**
 * @ClassNameSumOfNumber
 * @Description
 * @Author ANGLE0
 * @Date 2019/12/23 20:31
 * @Version V1.0
 **/
public class SumOfNumber {

    /*
     * DES：
     *      [三数之和为0]
     *      A+B+C = 0,返回不重复的三元组
     *
     *
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ArrayList a = new ArrayList();
                    a.add(nums[i]);
                    a.add(nums[L]);
                    a.add(nums[R]);
                    result.add(a);
                    while (L<R  && nums[L] == nums[L+1]) L++;
                    while (L<R  && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return result;
    }
}
