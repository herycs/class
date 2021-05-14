package com.w.exam.demo4;

import java.util.Arrays;
import java.util.Scanner;

public class sort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int[] tar = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
            tar[i] = nums[i];
        }
        Arrays.sort(tar);
        System.out.print(getNum(nums, tar) - 1);
    }

    public static int getNum(int[] nums, int[] tar){
        int indexi = 0;
        int indexj = 0;
        int count = 0;
        while (indexi < nums.length && indexj < tar.length){
            if (nums[indexi] != tar[indexj]){
                indexi++;
                indexj++;
                count++;
            }else {
                indexi++;
                indexj++;
            }
        }
        return count;
    }

}
/**
 * @ClassName sort
 * @Description [每次交换两个数字，最少多少次使得序列有序]
 * @Author ANGLE0
 * @Date 2020/7/22 17:35
 * @Version V1.0
 **/