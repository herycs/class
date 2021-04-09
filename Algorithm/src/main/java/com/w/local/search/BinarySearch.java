package com.w.local.search;

import java.util.Scanner;

/**
 * @ClassName BinarySearch
 * @Description [二分查找]
 * @Author ANGLE0
 * @Date 2020/7/23 17:03
 * @Version V1.0
 **/
public class BinarySearch implements Search{

    public int find(int[] nums, int target){
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int middle = (left + right) / 2;
            if (nums[middle] == target){
                return middle;
            } else if (nums[middle] < target){
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    @Override
    public int search(int[] nums, int target) {
//        return find(nums, target);
        return binarySearch(nums, target);
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = 0;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
