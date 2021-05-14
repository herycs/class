package com.w.exam.demo2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description [符合条件的数字，被7整合，不去重]
 * @Author ANGLE0
 * @Date 2020/8/1 15:19
 * @Version V1.0
 **/
public class Main2 {

    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.substring(1, str.length() - 1);
        String[] strings = str.split(",");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }

        range(nums);

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            int t = list.get(i);
            System.out.println(t);
            if (t / 7 == 0 && t % 7 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void range(int[] nums) {
        int temp = 0;
        int carry = 0;
        for (int j = 0; j < nums.length - 1; j++) {
            carry = 1;
            for (int i = j; i < nums.length; i++) {
                temp += nums[i] * carry;
                carry *= 10;
            }
            System.out.println(temp);
            swap(nums, j, j + 1);
            list.add(temp);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}