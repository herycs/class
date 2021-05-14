package com.w.local.sort.init.merger;

import com.w.local.sort.common.Sort;

/**
 * @ClassName Merger
 * @Description [归并排序]
 * @Author ANGLE0
 * @Date 2020/5/2 21:55
 * @Version V1.0
 **/
public class Merger implements Sort {

    @Override
    public void sort(int[] nums){
        this.mergerSort(nums, 0, nums.length-1);
    }

    /**
     * 递归调用
     * */
    public void mergerSort(int[] nums, int left, int right){
        if (left == right) return;
        //计算索引位置，将数组拆分为两部分
        int mid = left + (right-left)/2;
        //sort left
        mergerSort(nums, left, mid);
        //sort right
        mergerSort(nums, mid+1, right);

        merger(nums, left, mid+1, right);
    }

    /**
    * merger算法：递归方式
    * */
    public void merger(int[] nums, int leftPos, int rightPos, int rightBound){
        int mid = rightPos - 1;
        //leftPos代表待排序数组的最左端
        //rightPos代表待排序数组的最右端
        //不适用nums.length是因为这里采用递归的方式，故待排序数组实际上是左右边界决定的
        int[] temp = new int[rightBound - leftPos + 1];
        //目标数组的当前位置

        int i = leftPos;
        int j = rightPos;
        int resultPos = 0;

        //依次选取两部分最小的数作为新数组的值
        while(i <= mid && j <= rightBound){
            temp[resultPos++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }

        //若左边有未排完的数，则合并到总数组中
        while (i <= mid){
            temp[resultPos++] = nums[i++];
        }
        //若右边有未排完的数，则合并到总数组中
        while (j <= rightBound){
            temp[resultPos++] = nums[j++];
        }
        //拷贝：temp->nums
        for (int k = 0; k < temp.length; k++) {
            nums[leftPos+k] = temp[k];
        }
    }

    /**
     * 原始merger算法：依次选取两段数组中最小的作为新的数组的值
     * */
    public void mergerDemo(int[] nums){
        int len = nums.length;
        int middle = len / 2;
        int[] resultNums = new int[len];

        //左半边开始的位置
        int leftPos = 0;
        //右半边开始的位置
        int rightPos = middle+1;
        //最终数组的当前位置
        int resultPos = 0;

        while (leftPos <= middle && rightPos < len){
            resultNums[resultPos++] = nums[leftPos] <= nums[rightPos] ? nums[leftPos++] : nums[rightPos++];
        }

        while (leftPos <= middle){
            resultNums[resultPos++] = nums[leftPos++];
        }

        while (rightPos < len){
            resultNums[resultPos++] = nums[rightPos++];
        }
    }
}
