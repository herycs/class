package com.w.exam.demo3;

import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description [投掷骰子]
 * @Author ANGLE0
 * @Date 2020/8/2 19:06
 * @Version V1.0
 **/
public class Main1 {

    public static int[] getResult(int[] nums, int target) {

        int[] res = new int[2];
        int backCount = 0;
        int lastStep = target;
        for (int i = 0; i < nums.length; i++) {
            if (lastStep - nums[i] == 0) {
                res[0] = -999;
                return res;
            } else if (lastStep - nums[i] > 0) {
                lastStep -= nums[i];
            } else {
                lastStep = nums[i] - lastStep;
                backCount++;
            }
        }
        res[0] = lastStep;
        res[1] = backCount;
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int step = scanner.nextInt();
        int times = scanner.nextInt();
        int[] steps = new int[times];
        for (int i = 0; i < steps.length; i++) {
            steps[i] = scanner.nextInt();
        }

        int[] res = getResult(steps, step);
        if (res[0] == -999) {
            System.out.println("paradox");
        } else {
            System.out.println(res[0] + " " + res[1]);
        }
    }

}
