package com.w.exam.demo30;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description [司机调度]
 * @Author ANGLE0
 * @Date 2020/10/13 11:22
 * @Version V1.0
 **/
public class Main2 {
    /*

            正值下班高峰时期，现有可载客司机数2N人，调度中心将调度相关司机服务A、B两个出行高峰区域。

        第 i 个司机前往服务A区域可得收入为 income[i][0]，前往服务B区域可得收入为 income[i][1]。

        返回将每位司机调度完成服务后，所有司机总可得的最高收入金额，要求每个区域都有 N 位司机服务。
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> aInCome = new ArrayList<>();
        ArrayList<Integer> bInCome = new ArrayList<>();
        while (in.hasNext()) {
            String line = in.nextLine();
            if (line.equals("#")) break;
            String[] inComes = line.split(" ");
            aInCome.add(Integer.parseInt(inComes[0]));
            bInCome.add(Integer.parseInt(inComes[1]));
        }
//        for (int i = 0; i < aInCome.size(); i++) {
//            System.out.println(aInCome.get(i) + " - " + bInCome.get(i));
//        }
        int[] arrange = new int[2];
        arrange[0] = 0;
        arrange[1] = 0;

        System.out.println(getMax(aInCome, bInCome, 0, 0, 0, 0));
    }

    static int getMax(ArrayList<Integer> aIncome, ArrayList<Integer> bIncome, int sum, int index, int a, int b) {
        return Math.max(
                maxInCome(aIncome, bIncome, aIncome.get(index), index + 1, a + 1, b),
                maxInCome(aIncome, bIncome, bIncome.get(index), index + 1, a, b + 1));
    }

    static int maxInCome(ArrayList<Integer> aIncome, ArrayList<Integer> bIncome, int sum, int index, int a, int b) {
//        System.out.println("index" + index + "---" + sum + " - index" + index);
        if (index > aIncome.size()) return -1;
        if (index == aIncome.size()) {
            if (a == b)
                return sum;
            return 0;
        }
        return Math.max(
                maxInCome(aIncome, bIncome, sum + aIncome.get(index), index + 1, a + 1, b),
                maxInCome(aIncome, bIncome, sum + bIncome.get(index), index + 1, a, b + 1));
    }
}
/*

10 30
100 200
150 50
60 20
#

440

150 50
10 30
100 200
60 20
#

 */