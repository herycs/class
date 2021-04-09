package com.w.local.sort.init;

import com.w.local.sort.common.Sort;

/**
 * @ClassName Count
 * @Description [计数排序]
 * @Author ANGLE0
 * @Date 2020/5/3 16:47
 * @Version V1.0
 **/
public class Count implements Sort {

    @Override
    public void sort(int[] nums) {
        this.sort2(nums);
    }

    /**
     * DES：[基础版]
     * [统计数字出现的次数，索引就是对应的数值，索引的值就是出现的次数]
     * a[1] = 2,表明：数字1出现两次
     */
    public static void sort1(int[] nums){
        int[] result = new int[nums.length];
        int[] count = new int[10000];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for (int i = 0, j = 0; i < count.length; i++) {
            while(count[i]-- > 0){
                result[j++] = i;
            }
        }

        for (int i = 0; i < result.length; i++) {
            nums[i] = result[i];
        }
    }

    /**
     * DES：[改进版:稳定]
     *
     * 累加数原理
     */
    public static void sort2(int[] nums) {
        int[] result = new int[nums.length];
        int[] count = new int[10000];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i]+count[i-1];
        }

        for (int i = nums.length-1; i >= 0 ; i--) {
            /**
             * 处理流程：
             *  count求和后实际索引处存放的值实质上是该值在最终数组中的索引位置，验证方式可以使用[3,5,7]==>推出的最终数组为[0,0,0,1,1,2,2]
             * 此处执行流程是：
             *  从原数组中开始读值（倒序），取出count数组中原数组值对应的位置{count(nums[i])}，将count数组中值-1后,在result数组中对应位置写下值
             * 理解：
             * 以count作为排序后结果的索引基准，将原数组中的值依次读出，并依据count计算出的索引，将该值存于结果数组中的指定位置
             * 简单总结：
             *  就是:count充当索引计算器，整个流程就是依次将原数组值，存放到count计算出的索引处
             * 稳定原因：
             *  此处由于是倒序，所以哪怕相等数值的顺序在结果数组中也是不会**改变**的
             */
            result[--count[nums[i]]] = nums[i];
        }

        for (int i = 0; i < result.length; i++) {
            nums[i] = result[i];
        }
    }
}
