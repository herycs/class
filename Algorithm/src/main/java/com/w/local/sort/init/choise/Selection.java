package com.w.local.sort.init.choise;

import com.w.local.sort.common.Sort;
import com.w.local.sort.utils.SortUtils;

/**
 * @ClassName Selection
 * @Description [选择排序]
 * @Author ANGLE0
 * @Date 2020/5/1 20:28
 * @Version V1.0
 **/
public class Selection implements Sort {

    public void selectSort(int[] nums){
        if (nums == null || nums.length < 2) return;

        for (int i = 0; i < nums.length - 1; i++) {
            int mixPos = i;//锁定当前最小值索引
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[mixPos] > nums[j])
                    mixPos = j;
            }
            if (mixPos != i) SortUtils.swap(nums, i, mixPos);
        }
    }

    public void sort(int[] nums){
        temp(nums);
    }

    // 依次将0,1,2,...，位置存为第一小，第二小，，，
    public void temp(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[index] > nums[j]) {
                    index = j;
                }
            }
            if (index != i) SortUtils.swap(nums, i, index);
        }
    }
}
