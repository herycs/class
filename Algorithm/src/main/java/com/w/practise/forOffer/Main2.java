package com.w.practise.forOffer;

import org.junit.Test;

/**
 * @ClassName Main2
 * @Description [地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？]
 * @Author ANGLE0
 * @Date 2020/6/19 14:38
 * @Version V1.0
 **/
public class Main2 {

    //解法2
    public int movingCount2(int threshold, int rows, int cols) {
        //参数合法性验证
        if (threshold < 0 || rows < 1 || cols < 1) return 0;
        //java 默认初始化为false
        boolean[] flags = new boolean[rows * cols];
        return movCount(threshold, rows, cols, 0, 0,  flags);
    }
    // x y 0 0
    // x y 0 +1
    // x y +1 0
    // x y -1 0
    // x y 0 -1
    public int movCount(int threshold, int rows, int cols, int currRow, int currCol,  boolean[] flags){
        //边界值检查
        if (currRow < 0 || currRow >= rows || currCol  < 0 || currCol >= cols) return 0;
        //索引定位,行数 * 数组列数 + 当前列数
        int index = currRow * cols + currCol;
        System.out.println("操作索引" + index);
        //位置合法性判定
        if (flags[index] || checkCondition(currRow,  currCol, threshold)) return 0;
        //标记位置合法
        flags[index] = true;
        //递归, 依次为[0][0]号单元，向右， 下，左，上位置移动
        return 1
                + movCount(threshold, rows, cols, currRow, currCol+1, flags)
                + movCount(threshold, rows, cols, currRow+1, currCol, flags)
                + movCount(threshold, rows, cols, currRow, currCol-1, flags)
                + movCount(threshold, rows, cols, currRow-1, currCol, flags);
    }


    //解法1---存在问题
    // rows + cols < threshold,则为符合的格子
    public int movingCount(int threshold, int rows, int cols) {
        int count = 0;
        //遍历整个表格
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //符合要求则++
                if (checkCondition(i, j, threshold)){
                    count++;
                }
            }
        }
        return count;
    }

    //工具类
    //检查是否符合条件
    public boolean checkCondition(int num1, int num2, int standNum){
        int temp1 = 0;
        int temp2 = 0;
        while (num1 != 0){
            temp1 += num1 % 10;//获取个位
            num1 /= 10;
        }
        while (num2 !=  0){
            temp2 += num2 % 10;
            num2 /= 10;
        }
        return temp1 + temp2 > standNum;
    }

    @Test
    public void test(){
        System.out.println(movingCount(15, 20, 20));
    }

    @Test
    public void test2(){
        System.out.println(movingCount2(0, 1, 1));
    }

}
