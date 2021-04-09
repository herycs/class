package com.w.exam.demo10;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description [demo 大疆]
 * @Author ANGLE0
 * @Date 2020/8/16 18:47
 * @Version V1.0
 **/
public class Main {
    /*
    有许多程序员都热爱玩游戏，而小J自称为游戏王，曾玩过几百种游戏，几乎所有能玩到的游戏大作都玩遍了。随着时间的推移，他发觉已经没有游戏可以让他玩了！
    于是他想改玩一些古老的游戏，以成为真正的“游戏王”。
    他希望在接下来的一段时间内将过去出的游戏全部玩一遍，但是毕竟时间有限，因此他感到很苦恼。
    于是他想到一个计划，他先将每个游戏标上一个成就值，同时对每个游戏都估算一个通关所需要的天数，
    他计划在未来X天内让自己玩游戏的成就达到最大，那么他应该怎么做计划呢？
    （假设每个游戏最多只计划玩一遍，而且每个游戏必须玩完通关才能取得成就值，且通关每个游戏最小时间单位是1天）
     */
    /*
2 2
10 1
20 2
20
     */

    static class Info{
        int score;
        int time;
        public Info(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
    // 递归
    public static int getMax(Info[] infos, int index, int score, int time) {
        if (index == infos.length || time <= 0) return score;

        int p1 = getMax(infos, index + 1, score, time);

        int p2 = 0;
        if (time - infos[index].time >= 0 )
            p2 = getMax(infos, index + 1, score + infos[index].score, time - infos[index].time);

        return Math.max(p1, p2);
    }
    // 动态规划
    public static int getMax(Info[] infos, int time) {
        int n = infos.length + 1;
        int m = time + 1;
        int[][] dp = new int[n][m];
        for (int i = 1; i <= n; i++) {
            for (int j = infos[i].time; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j] + infos[i].time);
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int time = in.nextInt();
            Info[] infos = new Info[n];
            for (int i = 0; i < infos.length; i++) {
                Info temp = new Info(in.nextInt(), in.nextInt());
                infos[i] = temp;
            }
//            System.out.println(getMax(infos, 0, 0, time));
            System.out.println(getMax(infos, time));
        }
    }
}
