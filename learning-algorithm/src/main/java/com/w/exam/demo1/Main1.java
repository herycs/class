package com.w.exam.demo1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description [2]
 * @Author ANGLE0
 * @Date 2020/7/15 19:17
 * @Version V1.0
 **/
public class Main1 {
    //至少出现k次的元素
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int len = in.nextInt();
        int times = in.nextInt();

        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = in.nextInt();
        }

        HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];
            if (numbers.containsKey(temp)){
                numbers.put(temp, numbers.get(temp) + 1);
            }else {
                numbers.put(temp, 0);
            }
        }

        int res = -1;
        int maxTimes = times;
        for (int i = 0; i < nums.length; i++) {
            temp = numbers.get(nums[i]);//获取元素次数
            if (temp > maxTimes){
                maxTimes =  temp;
                res = nums[i];
            }else if (temp == times){
                res = nums[i];
            }
        }

        System.out.print(res);
    }
}
