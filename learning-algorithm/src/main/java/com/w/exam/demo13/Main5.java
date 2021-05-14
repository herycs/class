package com.w.exam.demo13;

import java.util.Scanner;

/**
 * @ClassName Main5
 * @Description [AB 分队]
 * @Author ANGLE0
 * @Date 2020/8/22 17:49
 * @Version V1.0
 **/
public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int len = x + y;
            int[] power = new int[len];
            for (int i = 0; i < len; i++) {
                power[i] = scanner.nextInt();
            }

            int[] ans = new int[len];
            int left = 0,right = len - 1;
            int leftSum = 0,rightSum = 0;
            int l = 0;
            int r = len - 1;
            for (int i = 0; i < len && l < x; i++) {
                if (leftSum < rightSum) {
                    leftSum += power[left++];
                    ans[l++] = 1;
                } else  if (right >= 0){
                    rightSum += power[right--];
                }
            }
            for (int i = 0; i < ans.length; i++) {
                System.out.print(ans[i] == 1 ? "A" : "B");
            }
//            for (int i = 0; i < x; i++) {
//                System.out.print("A");
//            }
//            for (int i = 0; i < y; i++) {
//                System.out.print("B");
//            }
        }
    }
}
/*

小团要组织一只队伍参加MT杯竞赛，某媒体赛前要对各参赛队伍实力进行评估，已知这个比赛要求每一个参赛方组织一支由x个人组成的A队，和y个人组成的B队，这个媒体在评估时会把A队的人员的平均实力值和B队人员的平均实力值相加，从而得到一个参赛方的综合实力评估。

小团可选的人手有限，只有x+y个人可以供他选择，但是显然不同的人员安排会有不同的综合实力评估，他希望他的综合实力评估尽可能高，请你帮助他完成分队。



输入描述
输入第一行包含两个正整数x，y，分别表示AB队的人数。(1<=x,y<=20000)

输入第二行包含x+y个正整数，中间用空格隔开，第i个数字表示第i个人的实力值，每个人的实力值不会超过20000，保证任意两个人都不会有相同的实力值。

输出描述
输出包含一个长度为x+y的字符串，每个字符是’A’或’B’，表示某人应该被分在A或B队。如果存在多种答案，则输出字典序最小的字符串。
 */
/*
4 4
5 6 4 2 3 8 1 7

AAAABBBB
 */
