package com.w.exam.demo3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description [上下左右四种方式能旋转为另外一个骰子则是同类]
 * @Author ANGLE0
 * @Date 2020/8/2 19:29
 * @Version V1.0
 **/
public class Main2 {

    // 同类骰子特征，有且仅有一组位置不同，顺序相反

    // 思路：以当前骰子序列号id为标准，查找2类筛子
    // id 完全一致的
    // id 有一组不同且顺序相反的（2位为一组，也就是上下一组前后一组）

    public static class Item{
        public String id;
        public int up;
        public int down;
        public int forward;
        public int behand;
        public int left;
        public int right;

        public Item(int up, int down, int forward, int behand, int left, int right) {
            this.id = up + "-" + down + "-" + forward + "-" + behand + "-" + left + "-" + right;
            this.up = up;
            this.down = down;
            this.forward = forward;
            this.behand = behand;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "id='" + id + '\'' +
                    ", up=" + up +
                    ", down=" + down +
                    ", forward=" + forward +
                    ", behand=" + behand +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static int[] getResult(Item[] items) {

        int[] res = new int[items.length];// 结果数组
        for (int i = 0; i < items.length; i++) {
            // 获取每个骰子的结果
            // 当前比对ID
            HashSet<String> set = new HashSet<>();
            set.add(items[i].id);
            for (int j = 0; j < 6; j++) {
                String p1 = items[i].up + "-" + items[i].down;
                String p2 = items[i].down + "-" + items[i].up;

                String p3 = items[i].forward + "-" + items[i].behand;
                String p4 = items[i].behand + "-" + items[i].forward;

                String p5 = items[i].left + "-" + items[i].right;
                String p6 = items[i].right + "-" + items[i].left;
                // 1,2      3,4     5,6
                // bac,分别转换顺序
                set.add(p4 + p1 + p5);
                set.add(p3 + p2 + p5);
                set.add(p3 + p1 + p6);
                // cba,分别转换顺序
                set.add(p6 + p3 + p1);
                set.add(p5 + p4 + p1);
                set.add(p5 + p3 + p2);
                // acb，分别转换顺序
                set.add(p2 + p3 + p5);
                set.add(p1 + p4 + p5);
                set.add(p1 + p3 + p6);
            }
            int temp = 0;
            for (int k = i; k < items.length; k++) {
                if (set.contains(items[i].id)) {
                    temp++;
                }
            }
            res[i] = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
             items[i] = new Item(scanner.nextInt(), scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
        }
        int[] res = getResult(items);

        int count = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] > 1) count++;
        }
        System.out.println(n - count);
        for (int i = 0; i < count; i++) {
            System.out.print(res[i] + " ");
        }
    }

}
