package com.w.exam.demo1;

import java.util.Scanner;

/**
 * @ClassName Main7
 * @Description [股票交易]
 * @Author ANGLE0
 * @Date 2020/7/15 20:58
 * @Version V1.0
 **/
public class Main7 {
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
}
