package com.w.local.sort.init;

import com.w.local.sort.common.Sort;

import java.util.Arrays;

/**
 * @ClassName baseNum
 * @Description [基数排序]
 * @Author ANGLE0
 * @Date 2020/5/3 18:11
 * @Version V1.0
 **/
public class BaseNum implements Sort {
    @Override
    public void sort(int[] nums) {
        int[] result = new int[nums.length];
        //每一位只有0-9
        int[] count = new int[10];
        int numOfBit = 4;//数字最长位数

        //从个位开始轮询，直到最高位结束
        for (int i = 0; i < numOfBit; i++) {
            //平方，为获取对应位数值做准备
            int division = (int) Math.pow(10, i);
            //计数排序，当前数值出现的次数
            for (int j = 0; j < nums.length; j++) {
                int num = nums[j] / division % 10;
                count[num]++;
            }
            //计数排序稳定化
            for (int j = 1; j < count.length; j++) {
                count[j] = count[j] + count[j-1];
            }
            //计数排序，实质数据拷贝
            for (int j = nums.length-1; j >= 0; j--) {
                int num = nums[j] / division % 10;
                result[--count[num]] = nums[j];
            }
            //将当前排序结果copy--->nums作为下次排序的原始数据
            System.arraycopy(result, 0, nums, 0, nums.length);
            Arrays.fill(count,0);
        }
        //上述过程排序完，实质上整个排序结束copy result--->nums
        for (int i = 0; i < result.length; i++) {
            nums[i] = result[i];
        }
    }
}
