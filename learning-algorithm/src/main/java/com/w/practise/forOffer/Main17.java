package com.w.practise.forOffer;

import java.util.ArrayList;

/**
 * @ClassName Main17
 * @Description [1~最大的N位数]
 * @Author ANGLE0
 * @Date 2020/8/2 8:30
 * @Version V1.0
 **/
public class Main17 {

    static ArrayList<Integer> list = new ArrayList<>();

    public static void arrange(int[] nums, int index) {
        if (index == nums.length) {
            list.add(getValue(nums));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            System.out.println(i);
            System.out.print("index = " + index + "---" + nums[0] + "-" + nums[1] + "-" + nums[2] + "\n");
            arrange(nums, index + 1);
            swap(nums, index, i);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int getValue(int[] nums) {
        int res = 0;
        int carry = 1;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i] * carry;
            carry *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        arrange(nums, 0);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
