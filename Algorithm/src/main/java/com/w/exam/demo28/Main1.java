package com.w.exam.demo28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName Main1
 * @Description [华为一面]
 * @Author ANGLE0
 * @Date 2020/9/14 13:33
 * @Version V1.0
 **/
public class Main1 {
    // 三数字之和，最接近target
    public int[] getThreeSumClosest(int[] nums, int sumSize, int target) {
        int[] resIndex = new int[4]; // left middle right (target - sum)
        if (nums == null || nums.length < 3|| sumSize < 0) return resIndex; // 入参异常
        HashMap<Integer, Integer> sumsMap = new HashMap<>();

        // 搜索差值
//        int min = 0;
//        for (int i = 0; i < nums.length; i++) {
//            resIndex[0] = i;
//            for (int j = i + 1; j < nums.length; j++) {
//                resIndex[1] = j;
//                int tempSp = target - nums[i] - nums[j]; // 当前需求差值
//                for (int k = j; k < nums.length; k++) {
//                    int currMinSp = nums[k];
//                    if (nums[k] == tempSp) {
//                        resIndex[2] = k;
//                    } else {
//                        if (nums[k] < currMinSp) {
//                            currMinSp = Math.max(currMinSp, nums[k]); // 差值小于需求值，取最大的
//                            resIndex[2] = k;
//                        }
//                    }
//                }
//            }
//        }// -

        // 三指针，索引查找
        // nums   [ 2   3  4  5  1  5  6   6]
        // index  left  middle            right
        // left + 1 = middle, middle + 1 = right
        // target - sum
        Arrays.sort(nums);
        int left = 0;
        int middle = 1;
        int right = nums.length - 1;
        while (left < middle && middle < right) {
            int sp = target - getSpOfNums(nums, left, middle, right);
            if (sp == 0) {
                resIndex[0] = left;
                resIndex[1] = middle;
                resIndex[2] = right;
            }

            int p1 = 0;
            int p2 = 0;
            int p3 = 0;
            if (sp >= 0) {
                p1 = target - getSpOfNums(nums, left, middle + 1, right); // 中间值右移
                p2 = target - getSpOfNums(nums, left + 1, middle, right); // 左边界右移
            }
            if (sp < 0){
                p3 = target - getSpOfNums(nums, left, middle, right - 1); // 右边界左移
            }

            // 更新边界值
            if (Math.abs(p1) < Math.abs(p2)) {
                middle++;
            } else if (Math.abs(p2) < Math.abs(p3)){
                left++;
            } else {
                right--;
            }
        }

        return resIndex;
    }

    public static ArrayList<Integer> threeSumClosest(int[] nums, int sumSize, int target) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums == null || nums.length < 3 || sumSize < 0) return res;

        return res;
    }

    // sum of nums [left, middle, right]
    public int getSpOfNums(int[] nums, int left, int middle, int right) {
        return nums[left] + nums[middle] + right;
    }
}
