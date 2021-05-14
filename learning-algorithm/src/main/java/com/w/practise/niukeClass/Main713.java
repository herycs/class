package com.w.practise.niukeClass;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @ClassName Main7_13
 * @Description [最长可整合子数组（乱序数组，但数组中元素排序后，是一个增量为1的递增序列）]
 * @Author ANGLE0
 * @Date 2020/7/31 11:02
 * @Version V1.0
 **/
public class Main713 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        System.out.println(getMaxLen(nums));
    }

    public static int getMaxLen(int[] nums) {
        if (nums == null || nums.length < 1) return 0;

        HashSet<Integer> set = new HashSet<>();
        int min = 0;
        int max = 0;
        int res = 0;
        // 从 i 位置开始，遍历以 i 位置开始的每一个连续的子数组
        for (int i = 0; i < nums.length; i++) {
            set.clear();
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            for (int j = i; j < nums.length; j++) {
                if (set.contains(nums[j])) {
                    break;
                }
                set.add(nums[j]);
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                if ((j - i) == (max - min)) {
                    res = Math.max(res, max - min + 1);
                }
            }
        }
        return res;
    }
}
