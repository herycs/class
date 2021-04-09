package com.w.practise.forOffer;

import org.junit.Test;

/**
 * @ClassName Main1
 * @Description [题目描述 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。 输入描述: 输入一个数n，意义见题面。（2 <= n <= 60）]
 * @Author ANGLE0
 * @Date 2020/6/19 9:28
 * @Version V1.0
 **/
public class Main1 {
    /**
     * n = [2, 60], m = [2,+OO)
     * 分段过程：
     *  n = 2
     *      m = 2, (1,1) res = 1
     *  n = 3
     *      m = 2, (1,2) res = 2
     *      m = 3, (1,1,1) res = 1
     *  n = 4
     *      m = 2, (1,3) res = 3
     *      m = 3, (1,1,2) res = 2
     *      m = 4, (1,1,1,1) res = 1
     *
     *  重复部分：
     *      dp[3] 实质上是 1 * dp[2]
     *      dp[4] 实质上是 1 * dp[3] = 1 * 1 * dp[2]
     *
     *
     * */
    public int cutRope(int target) {
        int[] dp = new int[target+1];
        //异常数值处理
        if (target < 2) return -1;

        if (target == 2) return 1;
        if (target == 3) return 2;

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;//1 + 2
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[target];
    }

    @Test
    public void main() {
        System.out.println(this.cutRope(4));;
    }
}
