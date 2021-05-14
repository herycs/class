package com.w.exam.demo19;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description [位置]
 * @Author ANGLE0
 * @Date 2020/8/27 18:55
 * @Version V1.0
 **/
public class Main1 {
    /*
        只包含2,3,5的第n个数
     */
    public static int getNoNOfNums(int n) {
        if (n <= 0) return -1;

        int[] nums = new int[]{2,3,5};
        if (n <= 3) return nums[n - 1];

        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(2);
        list.addLast(3);
        list.addLast(5);

        int index = 0;
        int count = 3;
        int baseNum = 10;
        while (count < n) {
            index = 0;
            LinkedList<Integer> integers = new LinkedList<>();
            while (count < n && index <= 2) {
                for (int temp : list) {
                    if (count == n) break;
                    int result = nums[index] * baseNum + temp;
//                    System.out.println(result);
                    count++;
                    integers.addLast(result);
                }
                index++;
            }
            list = integers;
            baseNum *= 10;
        }
        return list.getLast();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();

//            System.out.println(getNoNOfNums(n));

            int[] nums = new int[]{2,3,5,
                    22,23,25,32,33,35,52,53,55,
                    222,223,225,232,233,235,252,253,255,};
            if (n < nums.length) {
                System.out.println(nums[n - 1]);
            } else {
                System.out.println(getNoNOfNums(n));
            }
        }
    }
}
/*
3
5
 */
