package com.w.exam.demo16;

import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description [图解]
 * @Author ANGLE0
 * @Date 2020/8/25 20:47
 * @Version V1.0
 **/
public class Main1 {
    /*
    在游戏设计中，为了方便玩家完成任务，一般都会提供自动寻路功能。假设在某个游戏中，一共有6个区域，这些区域之间满足以下条件：

1. 任意两个区域之间不一定可以直接到达

2. 路线是单向的，即如果V1可直接到V2，那么V2不可直接到V1

请设计一个程序，能够计算出V1到其他各个区域的最短时间。

以下输入输出内容请参考该图，例如

v1到（v1，v2…v5, v6）的距离为（0 1 12 -1 -1 -1）

v2到（v1，v2…v5, v6）的距离为（-1 0 9 3 -1 -1）

v3到（v1，v2…v5, v6）的距离为（-1 -1 0 -1 5 -1）

v4到（v1，v2…v5, v6）的距离为（-1 -1 4 0 13 15）

v5到（v1，v2…v5, v6）的距离为（-1 -1 -1 -1 0 4）

v6到（v1，v2…v5, v6）的距离为（-1 -1 -1 -1 -1 0）
     */
    /*

    输入描述
按行依次输入某区域到其他区域的传送时间，0表示当前区域，-1表示区域间不可直接传送

输出描述
V1到其他区域的最短时间
     */
    /*
    样例输入
0 1 12 -1 -1 -1
-1 0 9 3 -1 -1
-1 -1 0 -1 5 -1
-1 -1 4 0 13 15
-1 -1 -1 -1 0 4
-1 -1 -1 -1 -1 0
样例输出
1
8
4
13
17
     */
    public static void main(String[] args) {
        int[][] weight = new int[6][];

        String[] pointsStr = { "V1", "V2", "V3", "V4", "V5","V6"};
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < pointsStr.length; i++) {
            String[] valuesStr = input.nextLine().split(" ");
            int[] values = new int[valuesStr.length];
            for (int j = 0; j < valuesStr.length; j++) {
                values[j] = Integer.parseInt(valuesStr[j]);
            }
            weight[i] = values;
        }
        input.close();

        method(weight, pointsStr);
    }
    public static void method(int[][] w, String[] p){
        for (int i = 0; i < w.length; i++) {
            System.out.println("9999");
        }
    }
}
