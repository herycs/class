package com.w.exam.demo30;

import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description [�����]
 * @Author ANGLE0
 * @Date 2020/10/13 11:15
 * @Version V1.0
 **/
public class Main1 {
    /*
    ���ν����Ҫ��ҵ�ˣ���ͬѧ����Я���϶������ձ���ҵ���С�
    ����һ���г̽������һص��˾Ƶ귿�䣬��ʱ��ͬѧ�Ƕ��ܿڿʣ�ʯͷ������ѡ������ȥ¥�µ��Զ����������������֡�

    ������ֻ֧��Ӳ��֧���������˶�ֻ֧��10 ��50��100 ������
    һ�ι�����Ϊֻ�ܳ�һƿ���֣���ÿ�ι��������������Сö����Ӳ�ҡ�������Ͷ��100Բ������30Բ��������50Բһö��10Բ��ö��

    ������Ҫ����Ŀ��������� m��������ͷӵ�е� 10,50,100 ���Ӳ�ҵ�ö���ֱ��� a,b,c�����ֵļ۸���x(x��10�ı���)��

    �����������ʹ�ô�������Ǯ�ǹ��������,��������ҪͶ��Ӳ�� {����} ��

        �������룬



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
        ��Ҫ���ֵ�����Ϊ m
            10Ԫ������Ϊ a
            50Ԫ������Ϊ b
            100Ԫ������Ϊ c
            1ƿ���ֵļ۸�Ϊ x
     */
    static int buyCoke(int m, int a, int b, int c, int x) {
        int count = 0;

        int[] moneys = new int[3]; // 0: 10Ԫ��1: 50Ԫ��2: 100Ԫ
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
