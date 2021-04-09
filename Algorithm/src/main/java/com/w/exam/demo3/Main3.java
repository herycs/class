package com.w.exam.demo3;

import java.util.Scanner;

/**
 * @ClassName Main3
 * @Description [背包问题]
 * @Author ANGLE0
 * @Date 2020/8/2 20:32
 * @Version V1.0
 **/
public class Main3 {

    // 中餐种类，晚餐种类，目标美味值，严格相等

    /*

        5 1 9
        9 1
        4 9
        3 1
        2 3
        6 5
        9 8

        4

        1 1 0
        3 1
        2 1

        0


     */

    static class Item{
        public int hot;
        public int val;
        public Item (int hot, int val){
            this.hot = hot;
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int z =  scanner.nextInt();
        int w = scanner.nextInt();
        int target = scanner.nextInt();

        Item[] zs = new Item[z];
        for (int i = 0; i < z; i++) {
            zs[i] = new Item(scanner.nextInt(), scanner.nextInt());
        }

        Item[] ws = new Item[w];
        for (int i = 0; i < w; i++) {
            ws[i] = new Item(scanner.nextInt(), scanner.nextInt());
        }

        System.out.println(-1);
    }

    public static int getMethods(Item[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < target; j++) {

            }
        }
        return 0;
    }

}
