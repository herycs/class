package com.w.exam.demo23;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description [集合合并]
 * @Author ANGLE0
 * @Date 2020/9/6 21:00
 * @Version V1.0
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            ArrayList<int[]> list = new ArrayList<>();
            ArrayList<Integer> zeroList = new ArrayList<>();
            int i = 0;
            while (i++ < m) {
                int numberOfPeople = scanner.nextInt();
                int[] nums = new int[numberOfPeople];
                for (int j = 0; j < nums.length; j++) {
                    nums[j] = scanner.nextInt();
                    if (nums[j] == 0 && !zeroList.contains(i)) zeroList.add(i);
                }
                list.add(nums);
            }
            System.out.println(getNumberOfPeopleKnowsNews(list, zeroList));
        }
    }
    public static int getNumberOfPeopleKnowsNews(ArrayList<int[]> lists, ArrayList<Integer> zeroList) {
        if (lists.isEmpty()) return -1;
        HashSet<Integer> set = new HashSet<>();
        for (int i : zeroList) {
            int[] list = lists.get(i);
            for (int j = 0; j < list.length; j++) {
                set.add(list[j]);
            }
            lists.remove(i);
        }
        for (int[] currList : lists) {
            for (int i = 0; i < currList.length; i++) {
                if (set.contains(currList[i])) {
                    for (int number : currList) {
                        set.add(number);
                    }
                    break;
                }
            }
        }
//        for (int o : set) {
//            System.out.print(o + " ");
//        }
//        System.out.println();
        return set.size();
    }
}
/*
50 5
2 1 2
5 10 11 12 13 14
2 0 1
2 49 2
4 6 7 8 2

50 4
2 1 2
5 10 11 12 13 14
4 0 1 7 9
4 6 7 8 2
 */