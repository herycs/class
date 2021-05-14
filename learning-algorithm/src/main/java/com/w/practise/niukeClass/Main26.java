package com.w.practise.niukeClass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @ClassName Main26
 * @Description [安排机器]
 * @Author ANGLE0
 * @Date 2020/7/26 16:13
 * @Version V1.0
 **/
public class Main26 {

    static int MAX_GREAD = 100;

    static class Node{
        public int time;
        public int level;

        public Node(int time, int value){
            this.time = time;
            this.level = value;
        }
    }

    public static int[] arrangeMachine(Node[] task, Node[] machine){
        if (task == null || task.length == 0 || machine == null || machine.length == 0) return new int[0];

        Comparator comparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.time == o2.time){
                    return o2.level - o1.level;
                }
                return o2.time - o1.time;
            }
        };

        Arrays.sort(task, comparator);
        Arrays.sort(machine, comparator);

        int profit = 0;
        int count = 0;

        int[] mNum = new int[MAX_GREAD + 1];
        Arrays.fill(mNum, 0);

        for (int i = 0, j = 0; i < task.length; i++) {
            while (j < machine.length && machine[j].time >= task[i].time){
                mNum[machine[j].level]++;
                j++;
            }
            for (int k = task[i].level; k < mNum.length; k++) {
                if (mNum[k] > 0){
                    count++;
                    mNum[k]--;
                    profit += 200 * task[i].time + 3 * task[i].level;
                    break;
                }
            }
        }
        int[] ans = new int[2];
        ans[0] = count;
        ans[1] = profit;

        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Node[] machine = new Node[n];
        Node[] task = new Node[m];

        for (int i = 0; i < n; i++) {
            machine[i] = new Node(in.nextInt(), in.nextInt());
        }

        for (int i = 0; i < m; i++) {
            task[i] = new Node(in.nextInt(), in.nextInt());
        }

        int[] res = arrangeMachine(task, machine);
        System.out.println(res[0] + " " + res[1]);
    }
}
