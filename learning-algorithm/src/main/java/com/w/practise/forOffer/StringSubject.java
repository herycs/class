package com.w.practise.forOffer;

/**
 * @ClassName StringSubject
 * @Description [字符串类型题目]
 * @Author ANGLE0
 * @Date 2020/5/22 10:56
 * @Version V1.0
 **/
public class StringSubject {
    /**
     * Title： [字符串转数字]
     *
     * DESC: [  transform string to int]
     *      {
     *          get one of string to [temp],then [resultInt = temp -'0']
     *      }
     *      目标整数，故范围在 [Integer.MAX_VALUE, Integer.MIN_VALUE]
     */
    public int transformStringToInt(String s) throws Exception {
        //1.为空返回
        if (s == null || s.equals("")) throw new Exception("输入字符串不可为空！");
        //2.非空
        //正负之分
        //拆分为字符数组
        char[] chars = s.toCharArray();

        //是否正数
        boolean isPositive = false;
        //找到第一个非空字符
        int index = 0;
        while (chars[index] == ' '){
            index++;
        }
        if (chars[index] == '+'){
            isPositive = true;
        }

        int result = 1;
        for (int i = index; i < chars.length; i++) {
            int temp = chars[i] - '0';
            if (temp >= 0 && temp <= 9){
                //3.拼接结果，溢出处理
                if (result * 10 <= Integer.MAX_VALUE - temp){
                    result = result*10+temp;
                }else {
                    throw new Exception("数据溢出");
                }
            }else {
                throw new Exception("字符串内容异常!");
            }
        }
        return isPositive ? result : -result;
    }


}
