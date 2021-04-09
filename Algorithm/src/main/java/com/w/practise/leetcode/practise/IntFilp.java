package com.w.practise.leetcode.practise;

/**
 * @ClassName IntFilp
 * @Description [整数翻转]
 * @Author ANGLE0
 * @Date 2020/5/4 22:02
 * @Version V1.0
 **/
public class IntFilp {
    public int reverse(int x) {
        int result = 0;
        while (x != 0){
            int temp = x % 10;
            x/=10;

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && temp > 7))
                result = 0;
            else if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && temp < -8))
                result = 0;
            else
                result = result * 10 + temp;

        }
        return result;
    }

    private int revent1(int x) {
        int xx = Math.abs(x);
        int result = 0;
        int[] count = new int[11];

        //分解数
        int i = 0;//对应位数的10的次方数（也作为后面求出结果的指针结束位置），如此时是个位，则[=0],十位则等于[=1]
        int temp = 1;//控制循环退出
        while (temp > 0){
            int division = (int) Math.pow(10, i);
            temp = xx / division;
            count[i] = xx / division % 10;//求出当前最低位的值，并存入count指定10次方幂的位置
            i++;
        }
        //组合数，依次将count数组中的值取出来，count数组经过上面操作，数组中的值就是对应下标处的10的幂次
        //例如：count = [1,2]， 则得出的数为：sum = 1*10^0 + 2*10^2
        i--;//上面结束后[i = 实际位数 + 1]
        int bitNUm = i;//控制位数读取，三位数则读取到[索引=2]即可
        for (int j = 0; j < bitNUm; j++) {
            result += count[j]* Math.pow(10, --i);
        }
        if (x < 0){
            result = -result;
        }
        if (result - Integer.MAX_VALUE > 0 ||result - Integer.MIN_VALUE  > 0|| isOverFlow((int)result))return 0;
        return result;
    }

    public Boolean isOverFlow(int nub){
        boolean flag = false;
        if(nub < Integer.MIN_VALUE || nub > Integer.MAX_VALUE)flag = true;
        return flag;
    }

}
