package com.w.exam2.demo3_13;

import java.util.HashMap;

/**
 * @ClassName Demo1
 * @Description [ÖØ¸´Êý×Ö]
 * @Author ANGLE0
 * @Date 2021/3/13 19:43
 * @Version V1.0
 **/
public class Demo1 {
    public int duplicate (int[] nums) {
        // write code here

        if (nums == null || nums.length <= 1) return -1;

        HashMap<Integer, Integer> valueIndexMap = new HashMap();

        int currNum = -1;
        for (int i = 0; i < nums.length; i++) {
            currNum = nums[i];
            if (valueIndexMap.containsKey(currNum)) {
                return currNum;
            }
            valueIndexMap.put(currNum, i);
        }
        return -1;
    }
}
