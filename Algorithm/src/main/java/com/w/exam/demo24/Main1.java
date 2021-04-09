package com.w.exam.demo24;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description [敏感词替换，不考虑字母顺序]
 * @Author ANGLE0
 * @Date 2020/9/8 19:30
 * @Version V1.0
 **/
public class Main1 {
    private static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            set.clear();
            String keyWord = scanner.nextLine();
            String stance = scanner.nextLine();
            String targetWord = scanner.nextLine();

            componse(keyWord.toCharArray());
            for (String s : set) {
//                System.out.println(s);
                stance = stance.replace(s, targetWord);
            }
            System.out.println(stance);
        }
    }
    public static void componse(char[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                swap(nums, i, j);
                dfs(nums, i);
            }
        }
    }
    public static void dfs(char[] nums, int i) {
        for (int j = i; j < nums.length; j++) {
            for (int k = i + 1; k < nums.length; k++) {
                swap(nums, i, k);
                print(nums);
            }
        }
    }
    public static void swap(char[] nums, int i, int j) {
        if (nums != null && (i > 0 && i < nums.length) && (j > 0 && j < nums.length)) return;
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void print(char[] nums) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            builder.append(nums[i]);
        }
        if (!set.contains(builder.toString())) {
            set.add(builder.toString());
//            System.out.println(builder);
        }
//        System.out.println();
    }
}
    /*
you
i love you,oyu love me
jack

i love jack,jack love me
     */
