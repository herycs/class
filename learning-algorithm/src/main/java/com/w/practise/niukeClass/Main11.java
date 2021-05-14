package com.w.practise.niukeClass;

import java.util.Arrays;

/**
 * @ClassName Main11
 * @Description [定长绳子覆盖数组]
 * @Author ANGLE0
 * @Date 2020/7/25 11:01
 * @Version V1.0
 **/
public class Main11 {
    // 暴力破解
    // 遍历+二分
    // 最优解：双指针

    public static int maxPoint(int[] arr, int L) {
        if (arr == null || arr.length == 0 || L <= 0) return -1;

        int left = 0;
        int right = 0;
        int res = 0;
        while (left < arr.length){
            while (right < arr.length && (arr[right] - L) <= arr[left]){
                right++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static int maxPoint2(int[] arr, int L) {
        int left = 0;
        int right = 0;
        int N = arr.length;
        int max = 0;
        while (left < N) {
            while (right < N && arr[right] - arr[left] <= L) {
                right++;
            }
            max = Math.max(max, right - (left++));
        }
        return max;
    }


    // for test
    public static int test(int[] arr, int L) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int pre = i - 1;
            while (pre >= 0 && arr[i] - arr[pre] <= L) {
                pre--;
            }
            max = Math.max(max, i - pre);
        }
        return max;
    }

    // for test
    public static int[] generateArray(int len, int max) {
        int[] ans = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * max);
        }
        Arrays.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int len = 100;
        int max = 1000;
        int testTime = 100000;
        for (int i = 0; i < testTime; i++) {
            int L = (int) (Math.random() * max);
            int[] arr = generateArray(len, max);

            int ans2 = maxPoint2(arr, L);
            int ans3 = test(arr, L);
            if (ans2 != ans3) {
                System.out.println("oops!");
                break;
            }
        }

    }

}
