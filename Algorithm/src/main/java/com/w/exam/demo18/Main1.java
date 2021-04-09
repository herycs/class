package com.w.exam.demo18;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description [排列组合]
 * @Author ANGLE0
 * @Date 2020/8/27 11:23
 * @Version V1.0
 **/
public class Main1 {
    /*
        每张扑克牌三种属性，求n张扑克中随机抽取三张能得到的组合方案个数

4
A A A
A A A
B B B
C C C

5
A A A
A A A
B B B
C C C
C C C
     */
    public static int getMethods(String[] strs) {
        if (strs == null || strs.length == 0) return -1;
        ArrayList<String> resList = new ArrayList<>();
        String s1;
        String s2;
        String s3;
        for (int i = 0; i < strs.length - 2; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                for (int k = j + 1; k < strs.length; k++) {
                    s1 = strs[i];
                    s2 = strs[j];
                    s3 = strs[k];
                    String temp = s1 + s2 + s3;

                    if ((s1.equals(s2) && s1.equals(s3))      // 都一样
                        || (!s1.equals(s2) && !s1.equals(s3) && !s2.equals(s3))) {  // 都不一样
                        if (!resList.contains(temp)){
                        resList.add(temp);
                            System.out.println(temp);
                        }
                    }
                }
            }
        }
        return resList.size();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = Integer.parseInt(scanner.nextLine());
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                String[] temp = scanner.nextLine().split(" ");
                strs[i] = temp[0] + temp[1] + temp[2];
            }
            System.out.println(getMethods(strs));
        }
    }
}
/*
4
A A A
A A A
B B B
C C C
 */
