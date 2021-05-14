package com.w.local.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/**
 * @ClassName Test
 * @Description [查找测试]
 * @Author ANGLE0
 * @Date 2020/7/23 17:27
 * @Version V1.0
 **/
public class Test {

    public static long MAX_VALUE = 10000l; // 数值范围
    public static int NUMS_LEN = 25; // 数组长度
    public static int TARGET_NUM = 6; // 缓冲当前目标值

    private static void tsetSearchMethod(int[] nums) {
        TARGET_NUM = nums[new Random().nextInt() & (nums.length - 1)];
        System.out.println("目标值->索引：" + TARGET_NUM + "->" + new BinarySearch().search(nums, TARGET_NUM));
    }

    private static void fieldNums(int[] nums) {
        Random random = new Random();
        int max = 0;
        HashSet<Integer> numsSet = new HashSet<>();
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = (int) (random.nextInt() & MAX_VALUE);
            if (!numsSet.contains(temp)) {
                nums[i] = temp;
                numsSet.add(temp);
            } else {
                i--;
            }
        }
        Arrays.sort(nums);
    }

    private static void print(int[] nums) {
        int len = String.valueOf(MAX_VALUE).length();
        String template = "%-" + len + "d ";
        for (int i = 0; i < nums.length; i++) {
            System.out.printf(template, i);
        }
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.printf(template, nums[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = new int[NUMS_LEN];
        fieldNums(nums);

        print(nums);

        for (int i = 0; i < 5; i++) {
            tsetSearchMethod(nums);
        }
    }
}
