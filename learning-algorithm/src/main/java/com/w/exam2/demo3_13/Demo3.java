package com.w.exam2.demo3_13;

/**
 * @ClassName Demo3
 * @Description [平均等待时间]
 * @Author ANGLE0
 * @Date 2021/3/13 20:16
 * @Version V1.0
 **/
public class Demo3 {
    // 订单 到达时间，制作耗
    // 求平均耗时
    public static double averageWaitingTime (int[][] orders) {
        // write code here

        if (orders == null) return 0;

        int end = 0;
        int currTime = 0;
        int waitTime = 0;
        for (int i = 0; i < orders.length; i++) {
                currTime = orders[i][0];
                end = end < currTime ? currTime + orders[i][1] : end + orders[i][1];
                if (end > currTime)
                    waitTime += end - currTime;
            System.out.println(end);
        }

        return (double) waitTime / orders.length;
    }

    public static void main(String[] args) {
//        int[][] nums = new int[3][2];
//        nums[0][0] = 1;
//        nums[0][1] = 2;
//        nums[1][0] = 1;
//        nums[1][1] = 3;
//        nums[2][0] = 4;
//        nums[2][1] = 3;

        int[][] nums = new int[2][2];
        nums[0][0] = 1;
        nums[0][1] = 1;
        nums[1][0] = 5;
        nums[1][1] = 1;

        System.out.println(averageWaitingTime(nums));
    }
}
