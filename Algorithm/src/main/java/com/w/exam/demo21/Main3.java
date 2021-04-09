package com.w.exam.demo21;

import java.util.Scanner;

/**
 * @ClassName Main3
 * @Description [n个台阶跨越]
 * @Author ANGLE0
 * @Date 2020/9/3 20:19
 * @Version V1.0
 **/
public class Main3 {
    // n 阶台阶，m长步数，每一步和之前走的两步不同，求可走到最后的步数组合种数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int len = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println();
        }
    }
    public static int dfs(int curr, int m, int lastStep, int llStep) {
        if (curr < 0) return 0;
        if (curr == 0) return 1;
        int count = 0;
        for (int i = 1; i <= m; i++) {
            if (i != lastStep && i != llStep)
                count += dfs(curr - i, m, lastStep, llStep);
        }
        return count;
    }
}
