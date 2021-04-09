package com.w.exam.demo27;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description [迷宫]
 * @Author ANGLE0
 * @Date 2020/9/13 20:52
 * @Version V1.0
 **/
public class Main1 {
    /*
    一个大小为N*N，并且有若干个陷阱的迷宫，
    X星人现在站在迷宫左上角的起点（第1行第1列），迷宫的终点是右下角（第N行第N列）。

    X星人每次可以朝上、下、左、右四个方向行走，但不允许穿越墙壁。

    在迷宫中，
        “0”表示空地，
        “1”表示墙壁，
        “#”表示陷阱。

    X星人在迷宫中每行走一步需要1秒钟，但如果不幸掉入陷阱，则需要额外增加K秒的逃脱时间。
    如果终点位置恰好是陷阱，也需要计算时间。

    假设起点（左上角）既不是墙也不是陷阱，请问X星人从起点到终点最少需要多少时间？
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String[] line = scanner.nextLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);

            char[][] maps = new char[n][n];
            for (int i = 0; i < n; i++) {
                maps[i] = scanner.nextLine().toCharArray();
            }

            long ans = getAns(maps, k);
            if (ans == -1) {
                System.out.println("No solution");
            } else {
                System.out.println(ans);
            }
        }
    }
    private static long getAns(char[][] maps, int k) {
        long[][] ans = new long[maps.length][maps.length];

        ans[0][0] = 0;
        for (int i = 1; i < ans.length; i++) {
            if (maps[0][i] == '1' || maps[0][i - 1] == '1') ans[0][i] = -1;
            else {
                if (maps[0][i] == '#') {
                    ans[0][i] = ans[0][i - 1] + k + 1;
                }
                if (maps[0][i] == '0') {
                    ans[0][i] = ans[0][i - 1] + 1;
                }
            }
        }
        for (int i = 1; i < ans.length; i++) {
            if (maps[i][0] == '1' || maps[i - 1][0] == '1') ans[i][0] = -1;
            else {
                if (maps[i][0] == '#') ans[i][0] = ans[i - 1][0] + k + 1;
                if (maps[i][0] == '0') ans[i][0] = ans[i - 1][0] + 1;
            }
        }
//        print(ans);

        for (int i = 1; i < ans.length; i++) {
            for (int j = 1; j < ans.length; j++) {
                System.out.println(i + "-" + j + maps[i][j] + (maps[i][j] == '1'));
                if (maps[i][j] == '1' || (ans[i - 1][j] == -1 && ans[i][j - 1] == -1)) {
                    System.out.println("i:" + i + "j:" + j);
                    ans[i][j] = -1;
                } else {
                    int currVal = (maps[i][j] == '#' ? k + 1 : 1);
                    ans[i][j] = Math.min(
                            ans[i - 1][j] > 0 ? ans[i - 1][j] : Integer.MAX_VALUE,
                            ans[i][j - 1] > 0 ? ans[i][j - 1] : Integer.MAX_VALUE) + currVal;
                }
            }
        }
//        print(ans);
        return ans[ans.length - 1][ans.length - 1];
    }
    private static void dfs(ArrayList<Long> res, char[][] maps, int i, int j, int k, long times) {
        if (i < 0 || i >= maps.length || j < 0 || j >= maps.length || maps[i][j] == '1') return;

        if (i == maps.length - 1 && j == maps[0].length - 1) {
            if (maps[i][j] == '#') times += k;
            res.add(times);
        }

        char tempVal = maps[i][j];

        if (tempVal == '1' || tempVal == '/') return;
        if (tempVal == '#') times += k;

//        System.out.println("i:" + i + "j:" + j + "k:" + k);

        maps[i][j] = '/';
        dfs(res, maps, i, j + 1, k, times + 1);
        dfs(res, maps, i + 1, j, k, times + 1);
        dfs(res, maps, i, j - 1, k, times + 1);
        dfs(res, maps, i - 1, j, k, times + 1);
        maps[i][j] = tempVal;
    }
    // for each char of chars[][] and print
    private static void print(long[][] chars) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
    }
}
/*
3 2
0#0
0#1
000

3 2
0#0
0#1
001

4

 */