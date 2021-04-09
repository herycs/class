package com.w.exam.demo11;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @ClassName Main
 * @Description []
 * @Author ANGLE0
 * @Date 2020/8/19 15:54
 * @Version V1.0
 **/
public class Main {
    // 两个数组交集

    public static int[] getSulution(int[] nums, int[] nums2) {

        // 1
        HashMap<Integer, Integer> map1 = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map1.containsKey(nums[i])) {
                map1.put(nums[i], map1.get(nums[i]) + 1);
            }
            map1.put(nums[i], 1);
        }
        // k -- v   nums[i]  count();


        // 2
        // k -- v nums[i] count() - 1

        // 2 -- 2
        // 0 --> 2 -- out()
//        HashMap<Integer, Integer> res = new HashMap<>();
//        for (int i = 0; i < nums2.length; i++) {
//            if (map1.containsKey(nums2[i])) {
//                if (!res.containsKey(nums2[i])) {
//                    res.put(nums2[i], 1);
//                } else {
//                    int temp = res.get(nums2[i]) + 1;
////                    res.put(nums2[i], temp > map1.get(nums2[i]) ? temp : );
//                }
//            }
//        }

        // [1,2,2,3]
        // [1,2,2,2]

        // n * log(n)

        // [1, 2, 2, 3]
        return null;
    }

    public static void main(String[] args) {

    }
}
