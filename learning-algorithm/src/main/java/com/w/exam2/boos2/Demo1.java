package com.w.exam2.boos2;

/**
 * @ClassName Demo1
 * @Description [股票最大收益]
 * @Author ANGLE0
 * @Date 2021/4/17 14:43
 * @Version V1.0
 **/
public class Demo1 {
    public static void main(String[] args) {

//        int[] nums = new int[]{1,5, 3, 6, 4};
        int[] nums = new int[]{2, 2, 2};

        System.out.println(maxProfit(nums));

    }

    public static int maxProfit (int[] prices) {
        // write code here

        if (prices == null || prices.length == 0) return -1;


        int minValue = prices[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            } else {
                res = Math.max(res, prices[i] - minValue);
            }
        }


        return res;


    }

}
