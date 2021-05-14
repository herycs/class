package com.w.practise.leetcode.practise;

/**
 * @ClassName rmElement
 * @Description [移除相同元素]
 * @Author ANGLE0
 * @Date 2020/5/5 16:50
 * @Version V1.0
 **/
public class rmElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int count = 0;
        int index = 0;

        while (index <= len-1-count){
            /**
             * 从前向后找到第一个[==val]的数的索引
             * index < len，避免越界
             */
            while (index < len && nums[index] != val){
                index++;
            }
            /**从后向前找到第一个[!=val]的数的索引
             * count < len，避免越界
             */
            while (count < len && nums[len-1-count] == val){
                count++;
            }
            //相等,则当前数组中没有可保留的值
            if (count == len)
                return 0;
            //index < len-1-count,数组未找完，且当前可交换
            if (index < len-1-count){
                swap(nums, index, len-1-count);
            }
        }
        //当前有效数据个数=原长度[len]-删除个数[count]
        return len-count;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
