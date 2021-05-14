package com.w;

/**
 * @ClassName Demo2
 * @Description []
 * @Author ANGLE0
 * @Date 2021/4/21 14:28
 * @Version V1.0
 **/
public class Demo2 {

    private long maxProfile(int[] nums) {

        if (nums == null || nums.length <= 1) return -1;


        int maxProf = Integer.MIN_VALUE;

        int currMin = nums[0];
        for (int i = 0; i < nums.length; i++) {

            maxProf = Math.max(nums[i] - currMin, maxProf);

            if (currMin > nums[i]) {
                currMin = nums[i];
            }

        }


        return maxProf;

    }

}
