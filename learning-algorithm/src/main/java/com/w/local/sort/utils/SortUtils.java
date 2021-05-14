package com.w.local.sort.utils;

import com.w.local.sort.common.Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName swap
 * @Description [交换]
 * @Author ANGLE0
 * @Date 2020/5/1 21:21
 * @Version V1.0
 **/
public class SortUtils {

    public static int arrayLength = 10000;
    public static int arrayMarge = 10000;

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void print(int[] nums){
        int len = nums.length-1;
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]+", ");
        }
        System.out.println(nums[len]+"]");
    }

    //校验排序正确性，通过生成乱序数组，比对系统方法和自己的方法排序后的比对效果
    // showFlag是否显示数组，Sort 排序算法
    public static void check(boolean showFlag, Sort sort){
        //准备两个相同的乱序数组
        int[] nums = SortUtils.generateRandomArray();
        int[] copyNums = new int[nums.length];
        System.arraycopy(nums, 0, copyNums, 0, nums.length);

        //分别用提供的工具和自己编写的工具排序
        Arrays.sort(nums);
        sort.sort(copyNums);

        //检查结果
        int checkResult = SortUtils.check(nums, copyNums);
        if (showFlag) SortUtils.print(copyNums);
        //打印排序结果
        System.out.print("the result of check is :"+(checkResult == 1? "Right": ((checkResult == -1) ?  "length1 != length2" :"Wrong")));
    }

    public static int[] generateRandomArray(){
        Random random = new Random();
        int[] nums = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            nums[i] = random.nextInt(arrayMarge);
        }
        return nums;
    }

    public static int check(int[] targetNums, int[] standardNums){
        if (targetNums.length != standardNums.length)
            return -1;
        for (int i = 0; i < targetNums.length; i++) {
            if (targetNums[i] != standardNums[i])
                return 0;
        }
        return 1;
    }
}
