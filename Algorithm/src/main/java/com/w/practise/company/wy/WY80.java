package com.w.practise.company.wy;

import java.util.Scanner;

/**
 * @ClassName WY80
 * @Description [情侣两两交换，求所有情侣都相邻的最小交换次数]
 * @Author ANGLE0
 * @Date 2020/8/9 9:18
 * @Version V1.0
 **/
public class WY80 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();

            int[] nums = new int[2 * n];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = in.nextInt();
            }

            System.out.println(solution(nums));
        }
    }

    public static int solution(int[] nums) {
        int count = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            // 遍历情侣数组
            start = i;
            end = i + 1;
            for (int j = end; j < nums.length; j++) {
                if (nums[start] == nums[j]) {
                    end = j;
                    break;// 找到 i 位置的另一半的索引位置 end = j
                }
            }
            if (i + 1 != end)
                swap(nums, i + 1, end);
            count += end - i - 1;
        }
        return count;
    }

    public static void swap(int[] nums, int i, int j) {
        for (int k = j; k >= i; k--) {
            nums[k] = nums[k - 1];
        }
    }
}
