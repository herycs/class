package com.w.local.sort.init.insert;

import com.w.local.sort.common.Sort;
import com.w.local.sort.utils.SortUtils;

/**
 * @ClassName InsertDirect
 * @Description [直接插入]
 * @Author ANGLE0
 * @Date 2019/12/30 19:28
 * @Version V1.0
 **/
public class InsertDirect implements Sort {

    public static void main(String[] args) throws Exception {

        int[] data = new int[]{33, 12, 25, 46, 37, 68, 19, 80};

        int[] nums = InsertDirect(data);
        int i;

        for (i = 1; i < nums.length; i++) {
            System.out.print(" "+nums[i]);
        }

    }

    /**
     * DES：
     *     [直接插入排序]
     */
    private static int[] InsertDirect(int[] data) throws Exception {
        if (data == null)
            throw new Exception("待排序列为空");
        int[] nums  = new int[data.length+1];
        for (int i = 0; i < data.length; i++) {
            nums[i+1] = data[i];
        }

        int i, j;
        for (i = 2; i < nums.length; i++) {
            nums[0] = nums[i];//保存待查数据
            for (j = i-1; nums[0] < nums[j]; j--) {
                nums[j + 1] = nums[j];//记录后移
            }
                nums[j+1] = nums[0];//插入正确位置
        }
        return nums;
    }

    /*
    * 简单方法：不断两两交换，直至到正确位置
    *   缺陷：需要交换算法
    *   改进方法：临时变量
    * 默认第一个数为已有序的序列，故开始位置为1
    * 从当前位置开始直到0号元素，只要小于前一个数则两两互换（此过程中因为前面是序列，故交换后当前数和之前序列构成一个新的有序序列）
    * 重复上面两步，直至所有序列排列完毕
    *
    * 类比：插扑克牌
    * */
    @Override
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j-1]){
                    SortUtils.swap(nums, j, j-1);
                }
            }
        }
    }
}
