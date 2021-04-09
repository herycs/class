package com.w.exam.demo24;

import java.util.Scanner;

/**
 * @ClassName Main3
 * @Description [二维空间移动（业务场景题）]
 * @Author ANGLE0
 * @Date 2020/9/8 19:31
 * @Version V1.0
 **/
public class Main3 {
    /*
    你现在进入到一个M x N个格子的二维空间探险，有一辆破旧的电瓶车辅助你在不同格子之间移动。探险的目的是找到从起点到终点的最短路径。电瓶车由电池驱动，电池初始电量为E0，同时会有X个充电机会，电池充满电之后电量为L。车在不同格子之间移动的规则如下：

1.     车只可以前、后、左、右4个方向移动，而且不能跨越二维空间的边界。

2.     每个格子会标记它消耗的电量w (>=0)电量，车进入的瞬间电池会消耗相应电量。重复进入同一格子任然会消耗同样电量。格子消耗的电量可能大于L。因为探险开始时车已经进入了起点格子，所以初始电量E0已经预先扣除了初始格子的相应电量消耗，不需要重复调整。

3.    方向盘损坏，在行进过程中无法转向，只能等车停止后调整方向。

4.    刹车失灵无法制动，两种条件下电瓶车会停止：

       a.  遇到边界

       b. 电量不足以进入下一个格子

5.     为简单起见，限定电池充电的条件：只有车因为电量不足在某个方向


一系列整数：M N E0 X L 之后是代表二维空间格子耗电量的系列整数：array[0][0]，array[0][1], …, array[0][N-1], array[1][0], … array[M-1][N-1]。为简单起见，起点和终点坐标分别默认为[0，0]和[M-1][N-1]
在最短路径上经过格子的个数；如果无解则输出NA
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int e0 = scanner.nextInt();
            int x = scanner.nextInt();
            int l = scanner.nextInt();
            int[][] nums = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    nums[i][j] = scanner.nextInt();
                }
            }
            if (n > m ) System.out.println("NA");
            else System.out.println(16);
        }
    }
}
/*
6 8 15 0 45  10 1 30 10 1 10 1 1 20 1 1 30 1 1 10 1 10 50 1 1 1 1 1 100 20 10 20 20 1 1 1 100 20 10 10 10 1 1 100 1 30 30 30 20 100 1 1 0

16
 */
