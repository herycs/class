package com.w.exam.demo13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description [跑腿问题，背包，价格，重量，订单总数，求获得最大价值的订单编号(字典序列最小)]
 * @Author ANGLE0
 * @Date 2020/8/22 17:13
 * @Version V1.0
 **/
public class Main2 {
    static class Info {
        int v;
        int w;
        int profile;
        int index;

        public Info(int v, int w, int profile, int index) {
            this.v = v;
            this.w = w;
            this.profile = profile;
            this.index = index;
        }
    }

    class Compater implements Comparator<Info> {
        @Override
        public int compare(Info o1, Info o2) {
            if (o1.w == o2.w)
                return o1.v - o2.v;
            return o1.w - o2.w;
        }
    }

    public static int[] getMaxProfile(Info[] nums, int n) {
        Arrays.sort(nums, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o2.profile == o1.profile)
                    return o1.index - o2.index;
                return o2.profile - o1.profile;
            }
        });
//        for (Info i : nums) {
//            System.out.println(i.index + "-" + i.v + "-" + i.w);
//        }
        int[] res = new int[n];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (index == n)
                break;
            res[index++] = nums[i].index;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            Info[] nums = new Info[n];
            for (int i = 0; i < n; i++) {
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                nums[i] = new Info(v, w, v + w * 2, i +1);
            }
            int[] res = getMaxProfile(nums, m);
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}
/*

5 2
5 10
8 9
1 4
7 9
6 10

2 5
 */