package com.w.practise.leetcode.practise;

/**
 * @ClassName bestReward
 * @Description [最大回报]
 * @Author ANGLE0
 * @Date 2020/5/6 18:01
 * @Version V1.0
 **/
public class bestReward {
    public int maxProfit(int[] prices) {
        int maxReward = 0;
        int mixPos = 0;

        for (int i = 0; i < prices.length; i++) {
            //找到价值最低点的值
            if (prices[mixPos] > prices[i] ){
                mixPos = i;
            }
            //找到最低点之后最大差值
            if (prices[i] - prices[mixPos] > maxReward){
                maxReward = prices[i] - prices[mixPos];
            }
        }
        return maxReward;
    }

    /**
     * DES：
     *     [暴力破解]
     *     一次将每一天作为第一天，之后的每一天作为卖出的时间
     *     循环比对，保留最大值
     */
    private int getMaxReward1(int[] prices) {
        int maxReward = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                int temp = prices[j] - prices[i];
                if (temp > maxReward) {
                    maxReward = temp;
                }
            }
        }
        return maxReward;
    }
}
