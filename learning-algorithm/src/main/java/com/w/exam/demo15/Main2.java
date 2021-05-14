package com.w.exam.demo15;

import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description [子序列，字典序第k小]
 * @Author ANGLE0
 * @Date 2020/8/23 20:28
 * @Version V1.0
 **/
public class Main2 {
    /*
    s的所有子串中输出字典序第k小的子串
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int k = scanner.nextInt();
            String[] arr = new String[k + 1];
            int index = 0;
            for (int i = 0; i < line.length(); i++) {
                for (int j = 1; j <= line.length()&& index <= k; j++) {
                    arr[index++] = line.substring(i, j);
                }
            }
            System.out.println(arr[k - 1]);
//            for (String s: arr) {
//                System.out.println(s);
//            }
//            System.out.println(line.substring(4, 4));
        }
    }
}
/*
aabb
3
aab
 */
