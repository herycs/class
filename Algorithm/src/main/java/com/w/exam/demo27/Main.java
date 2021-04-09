package com.w.exam.demo27;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description [百度金融]
 * @Author ANGLE0
 * @Date 2020/9/13 19:15
 * @Version V1.0
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int temp = 0;
            for (int i = 0; i < n * 3; i++) {
                temp += i + 1;
            }
            System.out.println(temp);
            System.out.println(temp * m);
        }
    }
}
/*

北京天坛的圜丘坛为古代祭天的场所，分上、中、下三层，上层中心有一块圆形石板（称为天心石），环绕天心石砌m块扇面形石板构成第一环，向外每环依次增加m块。下一层的第一环比上一层的最后一环多m块，向外每环依次增加m块。

已知每层环数相同。现给出每层的环数n和每一环比上一环增加的块数为m，求总共有多少块扇面形石板？

2 9

189

 */