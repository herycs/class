package com.w.practise.leetcode.practise;

/**
* @ClassName StringToInt
* @Description [字符串转整数]
* @Author ANGLE0
* @Date 2020/5/5 14:57
* @Version V1.0
**/
public class StringToInt {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int len = chars.length;
        int index = 0;
        int result = 0;
        boolean positiveNum = true;//是否正数
        //去除所有前置空字符
        while (index < len && chars[index] == ' '){
            index++;
        }
        //字符串结束，为空字符串
        if (index == len) return 0;

        //处理第一次遇到的符号位
        if (index < len && chars[index] == '+'){
            index++;
        }else if (index < len && chars[index] == '-'){
            positiveNum=false;
            index++;
        }else if (!Character.isDigit(chars[index])){
            //第一个非空字符字符不是 -, +, 数字，返回0
            return 0;
        }

        while (index < len && Character.isDigit(chars[index])){
            int temp = chars[index] - '0';
            //|| -result < (Integer.MIN_VALUE + temp) / 10
            int num = Integer.MAX_VALUE - temp;
            if (temp != 0 && !positiveNum)
                num = Integer.MAX_VALUE  - temp + 1;
            if (result > ( num / 10) )
                return positiveNum ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            result = result * 10 + temp;
            index++;
        }
        System.out.println("没越界");
        return positiveNum ? result : -result;
    }
}
