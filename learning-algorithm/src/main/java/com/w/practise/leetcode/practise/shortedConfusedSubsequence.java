package com.w.practise.leetcode.practise;

import java.util.Arrays;

/**
 * @ClassName shortedConfusedSubsequence
 * @Description [最短混乱子序列]
 * @Author ANGLE0
 * @Date 2020/5/8 19:21
 * @Version V1.0
 **/
public class shortedConfusedSubsequence {

    /**
     * Title： [策略同 findUnsortedSubarray2() ]
     */
    public int findUnsortedSubarray(int[] nums) {
        int left = nums.length;
        int len = nums.length;
        int right = 0;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if (nums[i] > nums[j]){
                    left = Math.min(left, i);
                    right = Math.max(right, j);
                }
            }
        }
        return right - left <  0 ? 0 : right - left + 1;
    }

    /**
     * DES： [轮询两次]
     *     第一次选取数组中的每一个数为[基准，i]
     *     第二次排序依次将当前[基准，i]和[当前值,j]比较，若存在[基准，i] > [当前值,j]，则当前位置是乱序数组中的位置
     *
     *     每次更新，乱序数组的最小边界和最大边界即可
     *
     *     每次[i]指向较小的一边
     *     每次[j]指向较大的一边
     */
    public int findUnsortedSubarray2(int[] nums) {
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }

    /**
     * Title： [拷贝一份排序后比对原数组找出不正确的位置]
     *
     * DESC: [对比排序数组和原数组，值不等则当前位置不是正确的位置（即当前位置是乱序数组中的位置）]
     *      {
     *          start保存第一个不正常位置
     *          end保留最后一个不正常位置
     *      }
     *
     * Time: O(n*log(n))
     * Space: O(n)
     *
     */
    public int findUnsortedSubarray3(int[] nums) {
        int[] snums = nums.clone();

        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                //虽然每次都和[i]比较，但当找到第一个不正常的位置时，start始终指向第一次的值（因为start = min, 而i是依次增大的）
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }
}
