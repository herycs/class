package com.w.practise.niukeClass;

import java.util.Scanner;

/**
 * @ClassName Main37
 * @Description [二叉树结构计数]
 * @Author ANGLE0
 * @Date 2020/7/27 8:44
 * @Version V1.0
 **/
public class Main37 {

    public final static int MOD = 1000000007;

    public static int countStructure(int n){
        if (n < 2) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {// 本次求的目标dp值，dp[i]
            for (int j = 1; j <= i; j++) {//遍历当前拥有 i 个结点的情况下的分配情况
                dp[i] += dp[j - 1] * dp[i - j];// 左为 j - 1,少一个根节点，右为 i - j
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(countStructure(n));
    }

}
