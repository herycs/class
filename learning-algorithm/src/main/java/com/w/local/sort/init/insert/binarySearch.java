package com.w.local.sort.init.insert;

/**
 * @ClassName binarySearch
 * @Description [折半查找]
 * @Author ANGLE0
 * @Date 2019/12/30 19:45
 * @Version V1.0
 **/
public class binarySearch {

    public static void main(String[] args) {
        int[] data = new int[] {33, 12, 25, 46, 37, 68, 19, 80};
        int[] nums = new int[data.length+1];
        for (int i = 0; i < data.length; i++) {
            nums[i+1] = data[i];
        }
        binarySort(nums);
        for (int i = 1; i < nums.length; i++) {
            System.out.print(" "+nums[i]);
        }
    }

    /**
     * DES：
     *     [折半插入排序]
     */
    private static void binarySort(int[] nums) {
        int low, height, mid;
        for (int i = 2;  i< nums.length; i++) {
            if (nums[i] < nums[i-1]){
                nums[0] = nums[i];
                low = 1;
                height = i-1;
                while (low <= height){
                    mid = (low+height) / 2;
                    if (nums[0] < nums[mid]){
                        height = mid-1;
                    }else {
                        low = mid+1;
                    }
                }
                for (int j = i-1; j >= low; j--) {
                    nums[j + 1] = nums[j];//后移元素
                }
                nums[low] = nums[0];//插入到正确位置
            }
        }
    }
}
