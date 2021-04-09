package com.w.exam.demo4;

import java.util.*;

public class Main {

    public static int getArea(int[] nums){
        if (nums == null || nums.length < 4) return -1;

        Arrays.sort(nums);//排序所有边

        //重复出现的边
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }

        int res = -1;
        int count = 0;
        int area = 1;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (map.get(nums[i]) >= 4)
                return (int) Math.pow(nums[i], 2);
            if (map.get(nums[i]) >= 2 && !list.contains(nums[i]))//列表中没有
                list.add(nums[i]);
        }

        if (list.size() < 2) return -1;

        int len1 = list.get(list.size() - 1);
        int len2 = list.get(0);
        return len1 * len2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(getArea(nums));
    }
}
