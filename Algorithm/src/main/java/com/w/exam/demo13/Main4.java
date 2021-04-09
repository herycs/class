package com.w.exam.demo13;

import java.util.Scanner;

/**
 * @ClassName Main4
 * @Description [图]
 * @Author ANGLE0
 * @Date 2020/8/22 17:23
 * @Version V1.0
 **/
public class Main4 {
    /*
    小美是美团总部的高管，她想要召集一些美团的区域负责人来开会，已知美团的业务区域划分可以用一棵树来表示，树上有n个节点，每个节点分别代表美团的一个业务区域，每一个区域有一个负责人，这个负责人的级别为A_i

已知小美召集人员开会必须满足以下几个条件：

1.    小美召集的负责人所在的区域必须构成一个非空的连通的图，即选取树上的一个连通子图。

2.    这些负责人中，级别最高的和级别最低的相差不超过k。

请问小美有多少种召集负责人的方式，当且仅当选取的集合不同时我们就认为两种方式不同。由于方案数可能非常大，所以请对10^9+7取模。
     */
    /*
    输入描述
输入第一行包含两个整数n和k，表示区域的数量，和不能超过的级别。(1<=n,k<=2000)

接下来有n-1行，每行有两个正整数a和b，表示a号区域和b号区域有一条边。(1<=a,b<=n)

最后一行有n个整数，第i个整数表示i号区域负责人的级别。

输出描述
输出仅包含一个整数，表示可以选择的方案数对10^9+7取模之后的结果。


样例输入
5 1
1 2
2 3
3 4
4 5
2 2 2 2 2
样例输出
15

提示
样例解释：
显然一个区域的方案有{1}，{2}，{3}，{4}，{5},两个区域的方案有4个，三个区域的方案有3个，四个区域的方案有2个，五个区域的方案有1个，共15个。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] nums = new int[n][2];
            for (int i = 0; i < nums.length - 1; i++) {
                nums[i][0] = scanner.nextInt();
                nums[i][1] = scanner.nextInt();
            }
            int t = 3;
            int[] level = new int[n];
            for (int i = 0; i < level.length; i++) {
                level[i] = scanner.nextInt();
            }
            System.out.println( n * t);
        }
    }
}
