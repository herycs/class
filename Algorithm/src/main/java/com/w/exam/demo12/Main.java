package com.w.exam.demo12;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description [金额单位转换]
 * @Author ANGLE0
 * @Date 2020/8/19 20:52
 * @Version V1.0
 **/
public class Main {
    /*

    输入一个 string -> long

    10.00 -> 1000
    1.0 -> 100
    0.11 -> 11
    1 -> 100
    1.11 -> 111
    1.111 -> throw Exception
    -1 -> throw Exception

    单位为元, 变为 单位为分

    考虑程序健壮性
     */

    /**
     * Title： [金额单位转换]
     *      {
     *          输入类型
     *          ""
     *          " "
     *          1
     *          -1
     *          x.xx
     *          0.xx
     *          xx.0
     *      }
     *
     *      数值处理：
     *          1.不包含小数点
     *          2.包含小数点
     *              2.1小数点前
     *              2.2小数点后
     *
     *      异常处理：
     *          1.异常输入
     *          2.long 类型返回值越界处理
     *              2147483648～2147483647 金额超过十亿，对于单笔结算量的限制而言已经能够满足
     *      若可能操作金额超过long 最大值，建议使用BigInteger
     *
     */

    private static final String EXP_INTEGER_AND_DECIMAL = "[0-9]+.[0-9]+";
    private static final String EXP_NUMBER = "[0-9]+";


    /**
     * 将String转换为对应的Long类型
     *  例如：00123 ---> 123
     * @param s
     * @return
     * @throws Exception
     */
    private static long parseStringToLong(String s) throws Exception {
        if (s == null || s.length() == 0 || s == " ") throw new Exception();
        int index = 0;
        long temp = 0;
        while (s.charAt(index) == 0) index++;
        if (index < s.length()) {
            try {
                temp += Long.parseLong(s.substring(index));
            } catch (NumberFormatException e) {
                throw new Exception("数值超范围");
            }
        }
        return temp;
    }

    private static long doublingLong(long num) throws Exception {
        if (num <= (Long.MAX_VALUE / 100)){
            return num * 100;
        } else {
            throw new Exception("数值超过处理范围");
        }
    }

    /**
     * @Desc 输入表示金额的字符串，完成从元到分的转换
     * @param  s
     * @return long
     * @throws Exception
     */
    public static long changeMoneyYuanToFree(String s) throws Exception {
        if (s == null || s.length() == 0 || s == " ") return 0l;
        long res = 0l;
        if (!s.contains(".")) {
            int index = 0;
            if (s.matches(EXP_NUMBER)) {
                res = doublingLong(parseStringToLong(s));
            } else {
                throw new Exception("数值不合法");
            }
        } else {
            if (!s.matches(EXP_INTEGER_AND_DECIMAL)) throw new Exception("输入不合法");

            if (s.length() - (s.indexOf(".") + 1) <= 2) {
                long integer_mod = doublingLong(parseStringToLong(s.substring(0, s.indexOf(".")))); // xx.mm 中的 [xx]转为100倍
                long decimal_mod = parseStringToLong(s.substring(s.indexOf(".") + 1)); // xx.mm 中的 [mm]转为100倍
                if (Long.MAX_VALUE - decimal_mod >= integer_mod) // 避免和的结果超范围
                    res = integer_mod + decimal_mod;
            } else {
                throw new Exception("小数部分精度不合法");
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String line = in.nextLine();
            System.out.println(changeMoneyYuanToFree(line));
        }
    }
}
