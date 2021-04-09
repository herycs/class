package com.w.exam.demo28;

/**
 * @ClassName Main2
 * @Description [二面]
 * @Author ANGLE0
 * @Date 2020/9/15 15:12
 * @Version V1.0
 **/
public class Main2 {
    /*
        int[] 重复值
        删去重复值

        [ x x x x x x, xxxxxx]
        slow            fast

        slow 更新当前应存放位置
        fast 用于遍历


     */

    public static void main(String[] args) {
//        int[] nums = new int[]{1,1,2};
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(deleteSameNumber(nums));
    }
    // 删除重复出现的数字
    public static int deleteSameNumber(int[] nums) {
        // 思路： 双指针
        if (nums == null || nums.length < 1) return -1; // 入参异常

        int slow = 0; // 慢指针
        int fast = 1; // 快指针
        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                fast++;
            } else {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
