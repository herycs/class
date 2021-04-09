package com.w.exam.demo21;

import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description [筛选合法牛奶]
 * @Author ANGLE0
 * @Date 2020/9/3 20:19
 * @Version V1.0
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int n = scanner.nextInt();
            int m = scanner.nextInt();
        }
    }
}
/*
1 ~ N
M条特性

测试组数
第一行，奶牛数量，需要满足的条件数量
一行一个正整数，这个特性在奶牛中满足的区间数量
k行，[l, r]

1
10 2
3
1 2
4 5
8 8
2
1 4
6 8

4
1 2 4 8

 */