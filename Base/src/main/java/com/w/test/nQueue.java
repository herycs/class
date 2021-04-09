package com.w.test;

/**
 * @ClassName nQueue
 * @Description [n皇后问题]
 * @Author ANGLE0
 * @Date 2020/6/5 16:38
 * @Version V1.0
 **/
public class nQueue {

    private int[] array = new int[8];//表示8*8的棋盘，array[n]==i;每个皇后放一行，第n个皇后即第n行，放置在第i列
    private int count = 0;//记录总的结果数量

    public static void main(String[] args) {
        nQueue nQueue = new nQueue();
        nQueue.check(0);//从第一个皇后开始递归
        System.out.print(nQueue.count);
    }

    /**
     * 摆放第n个皇后
     *
     * @param n
     */
    private void check(int n) {
        //使用递归求解：
        //递归的结束条件：n==8时，此时[0,7]个皇后已经摆放完成。
        if (n == 8) {
            print();//打印每一种结果
            return;//结束次此方法
        }
        //开始递归和回溯
        //递归发生在：不产生冲突的情况下：check(n+1);
        //回溯发生在：产生了冲突：则当前的check(n)不成立；重现摆放至下一个位置;
        for (int i = 0; i < 8; i++) {
            array[n] = i;//尝试将第n个皇后摆放在第i列；
            if (judge(n)) {//和第n个皇后之前的所有皇后比较，判断当前位置是否合法
                //如果合法，进入递归调用，开始安排第n+1个皇后的位置
                check(n + 1);
            }
            //否则的话，进入回溯环节，重新安排第n个皇后的位置即array[n]=i+1;
        }
    }

    /**
     * 判断该皇后放置的位置是否合法
     */
    private boolean judge(int n) {
        //不在同一行约束，采用array[]数组一定不再同一行
        //不同同一列：array[n1]!=array[n2];
        //不在同一对角线上array[n1]-array[n2]!=n1-n2,斜率不为1或者-1

        //当前的皇后和之前的所有皇后均要比较，只有全部符合才为true
        for (int i = 0; i < n; i++) {
            if (array[n] == array[i] || Math.abs(array[i] - array[n]) == Math.abs(i - n)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印摆放的结果
     */
    private void print() {
        count++;
        for (int i = 0; i < 8; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();//每一种结果换行
    }

}
