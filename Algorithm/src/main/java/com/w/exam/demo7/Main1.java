package com.w.exam.demo7;

import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description [找零钱]
 * @Author ANGLE0
 * @Date 2020/8/12 19:04
 * @Version V1.0
 **/
public class Main1 {
    public static int[] m = null;

    public static class Info{
        public boolean flag;
        public int id;
        public Info(boolean f, int id) {
            flag = f;
            this.id = id;
        }
    }
    public static Info getChange(int[] nums) {

        Info info = null;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 5) {
                return new Info(false, i + 1);
            } else {
                if (getMoney(nums[i])) {
                    info = new Info(true, i + 1);
                } else {
                    return new Info(false, i + 1);
                }
            }
        }
        return info;
    }

    public static boolean getMoney(int money) {
        if (money < 0) {
            return false;
        } else if (money == 5) {// 5 - 5
            return true;
        } else {
            if (money == 20 && m[0] > 0 && m[1] > 0) { // 20 - 5 = 10 + 5
                m[0]--;
                m[1]--;
                m[2]++;
                return true;
            } else if (money == 10 && m[0] > 0) { // 10 - 5 = 5
                m[0]--;
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            m = new int[3];
            String[] line = in.nextLine().split(",");
            int[] nums = new int[line.length];
            int index = 0;
            for (String s : line) {
                nums[index++] = Integer.parseInt(s);
            }
            Info info = getChange(nums);
            System.out.println(info.flag + "," +info.id);
        }
    }
}
