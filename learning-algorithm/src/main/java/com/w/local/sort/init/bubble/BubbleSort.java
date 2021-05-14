package com.w.local.sort.init.bubble;

import com.w.local.sort.common.Sort;
import com.w.local.sort.utils.SortUtils;

/**
 * @ClassName bubbleSort
 * @Description [冒泡排序]
 * @Author ANGLE0
 * @Date 2019/12/30 20:13
 * @Version V1.0
 **/
public class BubbleSort implements Sort {

    public static void main(String[] args) {

        int[] nums = new int[]{33, 12, 25, 46, 37, 68, 19, 80};

        bubbleSort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(" "+nums[i]);
        }

    }

    /**
     * DES：
     *     [冒泡排序，二次改进]
     *     在增加标志位基础上，增加无序边界的判定，减少比较范围
     */
    private static void bubbleSort2(int[] nums) {

        boolean flag = true;// flag = false,则数组已有序
        int arrBound = nums.length - 1;//无序数组边界，默认整个数组均乱序
        int lastSwapIndex = 0;//发生交换的最大边界值

        for (int i = 0; i < nums.length && flag; i++) {
            flag = false;
            for (int j = 0; j < arrBound; j++) {
                if (nums[j] > nums[j+1]){
                    SortUtils.swap(nums, j, j+1);
                    flag = true;
                    lastSwapIndex = j;
                }
            }
            arrBound = lastSwapIndex;
        }
    }

    /**
     * DES：
     *     [冒泡算法，一次改进]
     *     增加标志位，当出现未发生交换情况，则数据已有序，退出循环
     */
    private static void bubbleSort1(int[] nums) {
        boolean flag = true;
        for (int i = 0; i < nums.length && flag; i++) {
            flag = false;
            for (int j = 0; j < nums.length-1; j++) {
                if (nums[j] > nums[j + 1]){
                    SortUtils.swap(nums, j, j+1);
                    flag = true;
                }
            }
        }
    }

    private static void bubbleSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-1; j++) {
                if (nums[j] > nums[j+1]) SortUtils.swap(nums, j, j+1);
            }
        }
    }

    @Override
    public void sort(int[] nums) {
        bubbleSort2(nums);
    }

    // 思想：n * 两两交换
    // 改进，存在有序序列提前结束重复比较，存在有序序列，缩小比较范围
    public void bubbleSortTemp(int[] nums) {

    }
}
