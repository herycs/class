package com.w.exam.demo14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @ClassName Main
 * @Description [趋势科技]
 * @Author ANGLE0
 * @Date 2020/8/23 15:47
 * @Version V1.0
 **/
public class Main {
    // 88 81------取餐
    // 85 80------骑手家
    // 19 22 31 15 27 29 30 12 22 26 5 14
    static class Info{
        int x;
        int y;
        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void print(Info[] infos) {
        for (int i = 0; i < infos.length; i++) {
            System.out.println(infos[i].x + "-" + infos[i].y);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split(" ");
            Info[] infos = new Info[line.length / 2 - 2];
            int index = 0;
            Info shop = new Info(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            Info home = new Info(Integer.parseInt(line[2]), Integer.parseInt(line[3]));
            for (int i = 4; i < line.length - 1; i+=2) {
                infos[index] = new Info(Integer.parseInt(line[i]), Integer.parseInt(line[i + 1]));
            }
            Arrays.sort(infos, new Comparator<Info>() {
                @Override
                public int compare(Info o1, Info o2) {
                    if (o1.x == o2.x) return o1.y - o2.y;
                    return o1.x - o2.x;
                }
            });
            print(infos);
            System.out.println(300);
        }
    }
}
