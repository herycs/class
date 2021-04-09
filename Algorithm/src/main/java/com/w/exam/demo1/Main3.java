package com.w.exam.demo1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName Main3
 * @Description [罗马数字解析]
 * @Author ANGLE0
 * @Date 2020/7/15 20:14
 * @Version V1.0
 **/
public class Main3 {

    public int romanToInt(String s) {

        if (s == null || s == "") return -1;

        int preVal = get(s.charAt(0));
        int sum = 0;
        for (int i = 1; i < s.length(); i++){
            int currVal = get(s.charAt(i));

            if (preVal < currVal){
                sum -= preVal;
            } else {
                sum += preVal;
            }
            preVal = currVal;
        }
        sum += preVal;//循环结束时preVal是最后一个数值
        return sum;
    }

    public int get(char c){
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
