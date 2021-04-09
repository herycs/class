package com.w.exam.demo23;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @ClassName Main
 * @Description [腾讯]
 * @Author ANGLE0
 * @Date 2020/9/6 20:00
 * @Version V1.0
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            char[] cheers = scanner.nextLine().toCharArray();
            int[] ids = new int[n];
            String[] nums = scanner.nextLine().split(" ");
            for (int i = 0; i < ids.length; i++) {
                ids[i] = Integer.parseInt(nums[i]);
            }
            System.out.println(getMinSwapTimes(cheers, ids));
        }
    }
    public static int getMinSwapTimes(char[] chars, int[] ids) {
        int count = 0;
        for (int i = 0; i < ids.length - 1; i++) {
            if (ids[i] < ids[i + 1]) {
                swap(chars, ids, i, i + 1);
                count++;
            }
        }
        return count;
    }
    public static void swap(char[] chars, int[] ids, int i, int j) {
        char c = chars[i];
        int i1 = ids[i];
        chars[i] = chars[j];
        ids[i] = ids[j];
        chars[j] = c;
        ids[j] = i1;
    }
}
/*
3
BRRBRB
2 3 1 1 2 3

5
 */