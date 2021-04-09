package com.w.exam.demo17;

import java.util.ArrayList;

/**
 * @ClassName Main
 * @Description [完美]
 * @Author ANGLE0
 * @Date 2020/8/26 10:13
 * @Version V1.0
 **/
public class Main {
    // 矩阵行列清零
    // 无序，正整数
    class Info{
        int x;
        int y;
        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void clean(int[][] nums, int x, int y) {
        for (int i = 0; i < nums[0].length; i++) {
            nums[x][i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i][y] = 0;
        }
    }
    public void method(int[][] nums, int k) {
        if (k < 0 || nums == null || nums.length == 0 || nums[0].length == 0) return;
        ArrayList<Info> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (k == nums[i][j]) {
                    list.add(new Info(i, j));
                }
            }
        }
        for (Info info : list) {
            clean(nums, info.x, info.y);
        }
    }
}
/*
1 2 3 4
4 5 6 7
8 9 10 4

4

0 0 0 0
0 5 6 0
0 9 10 0
 */