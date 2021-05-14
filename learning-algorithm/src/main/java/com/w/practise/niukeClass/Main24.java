package com.w.practise.niukeClass;

import java.util.Scanner;

/**
 * @ClassName Main24
 * @Description [调整队行]
 * @Author ANGLE0
 * @Date 2020/7/26 15:35
 * @Version V1.0
 **/
public class Main24 {
    public static int findBestQueue(String sts){
        if (sts == null || sts.length() == 0) return -1;
        char[] c = sts.toCharArray();

        int ans1 = 0;
        int ans2 = 0;
        int pos1 = 0;
        int pos2 = 0;

        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'G'){
                ans1 += i - pos1;
                pos1++;
            } else if (c[i] == 'B'){
                ans2 += i - pos2;
                pos2++;
            }
        }
        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(findBestQueue(string));
    }
}
