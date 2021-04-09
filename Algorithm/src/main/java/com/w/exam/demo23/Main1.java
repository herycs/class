package com.w.exam.demo23;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description [降序链表找公共子集]
 * @Author ANGLE0
 * @Date 2020/9/6 20:19
 * @Version V1.0
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums1 = new int[n];
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = scanner.nextInt();
            }
            int m = scanner.nextInt();
            int[] nums2 = new int[m];
            for (int i = 0; i < nums2.length; i++) {
                nums2[i] = scanner.nextInt();
            }
            ArrayList<Integer> resList = getSamePart(nums1, nums2);
//            System.out.println(resList.size());
            for (int num : resList) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public static ArrayList<Integer> getSamePart(int[] a, int[] b) {
        ArrayList<Integer> list = new ArrayList<>();
        int indexA = 0;
        int indexB = 0;
        while (indexA < a.length && indexB < b.length) {
//            System.out.println(a[indexA] + "_" + b[indexB]);
            if (a[indexA] == b[indexB]) {
                list.add(a[indexA]);
                indexA++;
                indexB++;
            }else if (a[indexA] > b[indexB]) {
                indexA++;
            } else {
                indexB++;
            }
        }
        return list;
    }
}
/*
6
6 5 4 3 2 1
5
6 5 3 2 1

6 5 3 2 1
 */
