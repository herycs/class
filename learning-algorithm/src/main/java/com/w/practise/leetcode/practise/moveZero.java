package com.w.practise.leetcode.practise;

/**
 * @ClassName moveZero
 * @Description [移动值为0的元素到末尾]
 * @Author ANGLE0
 * @Date 2020/5/8 21:32
 * @Version V1.0
 **/
public class moveZero {
    /**
     * Title： [双指针]
     *
     * DESC: [ 一个指向此次非零元素该放的位置，一个寻找非零元素 ]
     *      {
     *             [start] 指向下一个非零该放的位置
     *             [i] 不断++后移找非零元素
     *      }
     *
     * Time: O( n )
     * Space: O( 1 )
     *
     */
    public void moveZeroes(int[] nums) {
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                swap(nums, start++, i);
            }
        }
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
