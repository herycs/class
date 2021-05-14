package com.w.oj;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int N, M;
        while (cin.hasNextInt()) {
            N = cin.nextInt();
            M = cin.nextInt();
            int[][] relation = new int[M][3];
            for (int i = 0; i < M; i++) {
                relation[i][0] = cin.nextInt();
                relation[i][1] = cin.nextInt();
                relation[i][2] = cin.nextInt();
            }
            int ret = help(relation, N);
            System.out.println(ret);
        }
    }

    public static int help(int[][] relation, int N) {
        Set<Integer> ret = new HashSet<>();
        Set<Integer> newf = new HashSet<>();
        ret.add(1);
        newf.add(1);
        while (!newf.isEmpty()) {
            Set<Integer> temp = new HashSet<>(newf);
            newf.clear();
            for (int[] re : relation) {
                if (re[2] == 0)
                    continue;
                if (temp.contains(re[0]) && !ret.contains(re[1])) {
                    ret.add(re[1]);
                    newf.add(re[1]);
                }
                if (temp.contains(re[1]) && !ret.contains(re[0])) {
                    ret.add(re[0]);
                    newf.add(re[0]);
                }
            }
        }
        return ret.size() - 1;
    }
}
