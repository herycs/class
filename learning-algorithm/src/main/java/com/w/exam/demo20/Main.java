package com.w.exam.demo20;

/**
 * @ClassName Main
 * @Description [欢聚集团 ]
 * @Author ANGLE0
 * @Date 2020/8/31 19:34
 * @Version V1.0
 **/
public class Main {
    /**
     * 找到比输入的整数大的下一个水仙花数
     * @param n int整型 输入的整数
     * @return long长整型
     */
    public long nextNarcissisticNumber (int n) {
        // write code here
        if (n < 9) {
            return n + 1;
        }
        int num = 2;

        return 153;
    }

    public static void main(String[] args) {
    }

    public static int[] getSplit(int n) {
        int len = String.valueOf(n).length(); // 当前数的位数
        int[] nums = new int[len];
        int temp = n;
        for (int i = 0; i < len; i++) {
            nums[i] = temp % 10;
            temp /= 10;
        }
        return nums;
    }

//    public int[] getFlowerNum(int n) {
//
//
//
//        int index = nums.length - 1;
//        long[] res = new long[2];
//        int resIndex = 0;
//        for (int i = 0; i < nums.length && resIndex < 2; i++) {
//            for (int j = 0; j < 9 && resIndex < 2; j++) {
//                nums[index] = j;
//                if (isFlowerNum(n, nums)) {
//                    res[resIndex++] = n;
//                }
//            }
//            index--;
//        }
//        return nums;
//    }

    public static boolean isFlowerNum(int target, int[] n) {
        int count = n.length;
        long sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum += Math.pow(n[i], count);
        }
        return target == sum;
    }
}
