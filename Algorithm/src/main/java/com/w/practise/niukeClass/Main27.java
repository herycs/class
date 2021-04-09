package com.w.practise.niukeClass;

/**
 * @ClassName Main27
 * @Description [画家小Q]
 * @Author ANGLE0
 * @Date 2020/7/26 17:31
 * @Version V1.0
 **/

import java.util.Scanner;

/**
 * 画家小Q又开始他的艺术创作。小Q拿出了一块有NxM像素格的画板, 画板初始状态是空白的,用'X'表示。
 * 小Q有他独特的绘画技巧,每次小Q会选择一条斜线, 如果斜线的方向形如'/',即斜率为1,小Q会选择这条斜线中的一段格子,都涂画为蓝色,用'B'表示;如果对角线的方向形如'\',即斜率为-1,小Q会选择这条斜线中的一段格子,都涂画为黄色,用'Y'表示。
 * 如果一个格子既被蓝色涂画过又被黄色涂画过,那么这个格子就会变成绿色,用'G'表示。
 * 小Q已经有想画出的作品的样子, 请你帮他计算一下他最少需要多少次操作完成这幅画。
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含两个正整数N和M(1 <= N, M <= 50), 表示画板的长宽。
 * 接下来的N行包含N个长度为M的字符串, 其中包含字符'B','Y','G','X',分别表示蓝色,黄色,绿色,空白。整个表示小Q要完成的作品。
 *
 *
 * 输出描述:
 * 输出一个正整数, 表示小Q最少需要多少次操作完成绘画。
 * 示例1
 * 输入
 * 4 4
 * YXXB
 * XYGX
 * XBYY
 * BXXY
 * 输出
 * 3
 * 说明
 * XXXX
 * XXXX
 * XXXX
 * XXXX
 * ->
 * YXXX
 * XYXX
 * XXYX
 * XXXY
 * ->
 * YXXB
 * XYBX
 * XBYX
 * BXXY
 * ->
 * YXXB
 * XYGX
 * XBYY
 * BXXY
 *
 * */
public class Main27 {

    public static int getPaintTimes(char[][] paint){
        if (paint == null || paint.length == 0 || paint[0].length == 0) return -1;

        int res = 0;
        for (int i = 0; i < paint.length; i++) {// 遍历行
            for (int j = 0; j < paint[0].length; j++) {// 遍历行
                int a = i;
                int b = j;//保存当前位置
                if (paint[a][b] == 'G' || paint[a][b] == 'Y'){// 判定当前位置，若为G | Y 则绘制过线条，绘画次数++
                    res++;
                }
                while (paint[a][b] == 'Y' || paint[a][b] == 'G'){// 向X的状态恢复
                    if (paint[a][b] == 'Y'){// ==Y则，一步到位
                        paint[a][b] = 'X';
                    } else if (paint[a][b] == 'G'){// == G，则先恢复到B
                        paint[a][b] = 'B';
                    }
                    a++;//向下一个对角线节点移动，此处就是右下角
                    b++;
                    if (a >= paint.length || b >= paint[0].length){
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < paint.length; i++) {
            for (int j = 0; j < paint[0].length; j++) {
                int a = i;
                int b = j;
                if (paint[a][b] == 'B'){
                    res++;
                }
                while (paint[a][b] == 'B'){
                    paint[a][b] = 'X';
                    a++;
                    b--;// 向斜率为 -1 的对角线方向移动
                    if (a >= paint.length || b <0){
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String temp = scanner.nextLine();
        int n = Integer.valueOf(temp.split(" ")[0]);
        int m = Integer.valueOf(temp.split(" ")[1]);
        char[][] chars = new char[n][m];

        for (int i = 0; i < n; i++) {
            temp = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                chars[i][j] = temp.charAt(j);
            }
        }
        System.out.println(getPaintTimes(chars));;
    }
}
