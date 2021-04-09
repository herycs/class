package com.w.exam.demo8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description [胡牌]
 * @Author ANGLE0
 * @Date 2020/8/12 21:26
 * @Version V1.0
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        list.add("147");
        list.add("258");
        list.add("369");
        int n = in.nextInt();
        for (int j = 0; j < n; j++) {
            String[] str = in.nextLine().split(" ");
            int[] t = new int[3];
            int[] b = new int[3];
            int[] w = new int[3];
            int ti = 0;
            int bi = 0;
            int wi = 0;
            for (int i = 0; i < str.length; i++) {
                System.out.println(str[i]);
//                if (str[i].contains("T")) {
//                    t[ti++] = str[i].charAt(0);
//                } else if (str[i].contains("B")) {
//                    b[bi++] = str[i].charAt(0);
//                } else {
//                    w[wi++] = str[i].charAt(0);
//                }
            }
            Arrays.sort(t);
            Arrays.sort(b);
            Arrays.sort(w);
            int count = 0;
            if (list.contains(change(t))) count++;
            if (list.contains(change(b))) count++;
            if (list.contains(change(w))) count++;
            if (count == 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }


    public static String change(int[] nums) {
        String s = "";
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
        }
        return s;
    }
}
/*

4
1T 4T 7T 2B 5B 8B 9W
1T 2T 3T 4T 5T 6T 7T
1B 2W 3T 4B 5W 6T 8W
2B 8B 5B 2B 6T 7W 4W


YES
NO
YES
NO

 */

/*

搜集宝箱

3
5 5
0...1
.#.#.
..*..
.#.#.
2...3
5 5
0...1
.#.#.
..*.#
.#.#.
2.#.3
5 5
....1
.####
..*..
####.
0....



16
-1
-1

 */
