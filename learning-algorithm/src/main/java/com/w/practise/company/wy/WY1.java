package com.w.practise.company.wy;

import java.io.*;
import java.util.*;

/**
 * @ClassName ClassForMoney
 * @Description [奖学金]
 * @Author ANGLE0
 * @Date 2020/8/8 14:10
 * @Version V1.0
 **/
public class WY1 extends Object{
    /*
    题目描述
        小v今年有n门课，每门都有考试，为了拿到奖学金，小v必须让自己的平均成绩至少为avg。每门课由平时成绩和考试成绩组成，满分为r。现在他知道每门课的平时成绩为ai ,若想让这门课的考试成绩多拿一分的话，小v要花bi 的时间复习，不复习的话当然就是0分。同时我们显然可以发现复习得再多也不会拿到超过满分的分数。为了拿到奖学金，小v至少要花多少时间复习。
    输入描述:
        第一行三个整数n,r,avg(n大于等于1小于等于1e5，r大于等于1小于等于1e9,avg大于等于1小于等于1e6)，接下来n行，每行两个整数ai和bi，均小于等于1e6大于等于1
    输出描述:
        一行输出答案。
     */

    static class Course{
        public int score;
        public int time;
        public Course(int s, int t) {
            this.score = s;
            this.time = t;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = in.readLine()) != null) {
            String[] firstLine = line.split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int r = Integer.parseInt(firstLine[1]);
            int avg = Integer.parseInt(firstLine[2]);

            int sum = 0; // 总分
            Course[] cs = new Course[n];
            for (int i = 0; i < n; i++) {
                String[] strs = in.readLine().split(" ");
                Course temp = new Course(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
                sum += temp.score;
                cs[i] = temp;
            }
            int lastSum = avg * n - sum;

            Arrays.sort(cs, new Comparator<Course>() {
                @Override
                public int compare(Course o1, Course o2) {
                    return o1.time - o2.time;
                }
            });

            long spent = 0;
            int j = 0;
            while (lastSum > 0) {
                if (cs[j].score < r) {// 可以提分
                    // 提多少分？
                    int temp = (r - cs[j].score) > lastSum ? lastSum : r - cs[j].score;
                    spent += temp * cs[j].time;
                    lastSum -= temp;
                }
                j++;
            }
            System.out.println(spent);
        }
    }
}
/*
5 10 9
0 5
9 1
8 1
0 1
9 100

43
*/