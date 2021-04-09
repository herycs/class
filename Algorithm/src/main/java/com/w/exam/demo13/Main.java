package com.w.exam.demo13;

import java.util.*;

/**
 * @ClassName Main
 * @Description [美团]
 * @Author ANGLE0
 * @Date 2020/8/22 16:01
 * @Version V1.0
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            int[] huo = new int[n];
            for (int i = 0; i < n; i++) {
                huo[i] = scanner.nextInt();
            }
            int[] order = new int[n];
            for (int i = 0; i < n; i++) {
                order[i] = scanner.nextInt();
            }

            int temp = order[0] - 1;
            int leftSum = 0;
            for (int i = 0; i < temp; i++) {
                leftSum += huo[i];
            }
            int rightSum = 0;
            for (int i = temp + 1; i < n; i++) {
                rightSum += huo[i];
            }

            System.out.println(Math.max(leftSum, rightSum));
            for (int i = 1; i < n; i++) {
                int index = order[i] - 1;
                if (index < temp) {
                    leftSum -= huo[index];
                } else {
                    rightSum -= huo[index];
                }
                System.out.println(Math.max(leftSum, rightSum));
            }
        }
    }
}
/*


 */


