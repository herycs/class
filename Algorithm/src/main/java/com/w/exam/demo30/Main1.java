package com.w.exam.demo30;

import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description [买可乐]
 * @Author ANGLE0
 * @Date 2020/10/13 11:15
 * @Version V1.0
 **/
public class Main1 {
    /*
    游游今年就要毕业了，和同学们在携程上定制了日本毕业旅行。
    愉快的一天行程结束后大家回到了酒店房间，这时候同学们都很口渴，石头剪刀布选出游游去楼下的自动贩卖机给大家买可乐。

    贩卖机只支持硬币支付，且收退都只支持10 ，50，100 三种面额。
    一次购买行为只能出一瓶可乐，且每次购买后总是找零最小枚数的硬币。（例如投入100圆，可乐30圆，则找零50圆一枚，10圆两枚）

    游游需要购买的可乐数量是 m，其中手头拥有的 10,50,100 面额硬币的枚数分别是 a,b,c，可乐的价格是x(x是10的倍数)。

    如果游游优先使用大面额购买且钱是够的情况下,请计算出需要投入硬币 {次数} ？

        依次输入，



     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        int _a;
        _a = Integer.parseInt(in.nextLine().trim());

        int _b;
        _b = Integer.parseInt(in.nextLine().trim());

        int _c;
        _c = Integer.parseInt(in.nextLine().trim());

        int _x;
        _x = Integer.parseInt(in.nextLine().trim());

        res = buyCoke(_m, _a, _b, _c, _x);
        System.out.println(String.valueOf(res));
    }

    /*
        需要可乐的数量为 m
            10元的张数为 a
            50元的张数为 b
            100元的张树为 c
            1瓶可乐的价格为 x
     */
    static int buyCoke(int m, int a, int b, int c, int x) {
        int count = 0;

        int[] moneys = new int[3]; // 0: 10元，1: 50元，2: 100元
        moneys[0] = a;
        moneys[1] = b;
        moneys[2] = c;

        int sumOfMoney = a * 10 + b * 50 + c * 100;

        while (sumOfMoney >= x && m > 0) {
            int temp = x;
            while (temp > 0) {
                while (temp > 0 && moneys[2] > 0) {
                    temp -= 100;
                    moneys[2]--;
                    count++;
                }
                while (temp > 0 && moneys[1] > 0) {
                    temp -= 50;
                    moneys[1]--;
                    count++;
                }
                while (temp > 0 && moneys[1] > 0) {
                    temp -= 10;
                    moneys[0]--;
                    count++;
                }
            }
            if (temp < 0) changeMoney(moneys, -temp);
            sumOfMoney -= x;
            m--;
        }

        return count;
    }

    static void changeMoney(int[] moneys, int outCome) {
        if (outCome == 100) {
            moneys[2]++;
        }
        if (outCome == 50) {
            moneys[1] += outCome / 50;
        } else {
            moneys[0] += outCome / 10;
        }
    }

}
/*

2
1
4
3
250
 */
