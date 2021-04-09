package com.w.local.sort.init.insert;

import com.w.local.sort.common.Sort;
import com.w.local.sort.utils.SortUtils;

/**
 * @ClassName shellSort
 * @Description [希尔排序]
 * @Author ANGLE0
 * @Date 2019/12/30 19:54
 * @Version V1.0
 **/
public class shellSort implements Sort {

    /**
     * DES：
     *     [排序函数]
     */
    private static void shellSort(int[] nums, int[] dlta, int t) {
        for (int k = 0; k < nums.length; t++) {
            shellInsert(nums, dlta[k]);
        }
    }

    /**
     * DES：
     *     [插入函数]
     */
    private static void shellInsert(int[] nums, int dk) {
        int i, j;
        for (i = dk+1; i < nums.length; i++) {
            if (nums[i] < nums[i-dk]) {
                nums[0] = nums[i];
                for (j = i-dk; j > 0 && nums[0] < nums[i]; j++) {
                    nums[j+dk] = nums[0];
                }
                nums[j+dk] = nums[0];
            }
        }
    }

    /*
    * 提升性能关键：
    *   最开始排序，间隔大，此时排序的交换次数少
    *   排序后期，间隔小，但交换举例短
    * 间隔排序：
    *   1.将一定间隔的数据进行排序，例如间隔为4，则将0,4,8,...排序（插入算法实现）
    *   2.缩小间隔
    *
    * 间隔问题：
    *   间隔写死显然是不合适的
    *       1.原始希尔：每次为上此间隔（第一次为数组长度）的1/2
    *       2.Kunth（唐纳德，序列）：h = 1, h = 3*h+1, 当采用的间隔大于数组的1/3，则不合适
    * */
    @Override
    public void sort(int[] nums) {
        int len = nums.length;
        int dk = 1;//排序基础间隔
        //间隔依据数组大小确定，算法Kunth
        while (dk < len / 3){
            dk = 3*dk+1;
        }
        while (dk > 0){
            //每次排序的是一个间隔的所有的数，因此每次i+1就是排列下一个间隔位置组成的排序数组
            for (int i = dk; i < len; i++) {
                //插入排序，区别就是基础插入排序每次比对的是相邻的数，而在此情况下相邻的数的下标相差一个间隔
                for (int j = i; j > dk-1; j-=dk) {
                    if (nums[j] < nums[j-dk]){
                        SortUtils.swap(nums, j, j-dk);
                    }
                }
            }
            //一个间隔为基础所有数据排序完后调整间隔
            dk = (dk-1) / 3;
        }
    }
}
