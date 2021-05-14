package com.w.local.sort.init.quick;

import com.w.local.sort.common.Sort;
import com.w.local.sort.utils.SortUtils;

/**
 * @ClassName quickSort
 * @Description [快排]
 * @Author ANGLE0
 * @Date 2019/12/30 20:21
 * @Version V1.0
 **/
public class QuickSort implements Sort {

    /**
     * 递归调用
     */
    public void qSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = partition(nums, left, right);
        qSort(nums, left, mid - 1);
        qSort(nums, mid + 1, right);
    }

    /**
     * 单次快排
     * 将范围内数据使用快排策略完成排序，同时返回中间值
     * 快排策略：
     * 找一个标准，将数组排序为两部分，一部分小于等于这个标准，一部分大于这个标准
     * 而后依次在两个分区，同时执行上述算法
     */
    public int partition(int[] nums, int left, int rightBound) {
        int target = nums[rightBound];
        int right = rightBound - 1;
        while (left <= right) {
            while (left <= right && nums[left] <= target) left++;
            while (left <= right && nums[right] > target) right--;
            if (left < right) SortUtils.swap(nums, left, right);
        }
        if (left != right) SortUtils.swap(nums, left, rightBound);
        return left;
    }

    @Override
    public void sort(int[] nums) {
        qSort(nums, 0, nums.length - 1);
    }

}
