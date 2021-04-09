package com.w.exam2.demo3_28;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Demo2
 * @Description [动态规划]
 * @Author ANGLE0
 * @Date 2021/3/28 19:48
 * @Version V1.0
 **/
public class Demo2 {
    /*
        5 10 2
        0 5
        8 6
        10 8
        18 12
        22 15

        第一行为 宝库个数，每次起飞可以走的最大距离，本次可以起飞的次数
        后面几行分别为 宝库位置，宝库价值

        目标：取得最大价值
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String[] s = scanner.nextLine().split(" ");
            int num = Integer.parseInt(s[0]);
            long step = Long.parseLong(s[1]);
            long times = Long.parseLong(s[2]);

            long[][] packArray = new long[num][2];
            for (int i = 0; i < num; i++) {
                String[] line = scanner.nextLine().split(" ");

                packArray[i][0] = Long.parseLong(line[0]);
                packArray[i][1] = Long.parseLong(line[1]);
            }
            System.out.println(calc(step, times, packArray));
        }
    }

       private static long calc(long step, long times, long[][] packArray) {
        long maxPosition = step * times;

        long currValue = 0;

        long[] valueArray = new long[2];
        for (int i = 1; i < packArray.length; i++) {
            currValue = packArray[i][1];
            if (packArray[i][0] <= maxPosition) {
                if (currValue > valueArray[0]) {
                    valueArray[1] = valueArray[0];
                    valueArray[0] = currValue;
                } else if (currValue > valueArray[1]){
                    valueArray[1] = currValue;
                }
            }
        }

        return packArray[0][1] + valueArray[0] + valueArray[1];
    }
}
