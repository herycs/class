package com.w.exam2.demo4_25;

import java.util.Scanner;

/**
 * @ClassName Demo2
 * @Description [
 *
 * 小美有一个由小写字母组成的字符串。小美认为字母表很有意思。所以他规定，在小写字母中，每个字母的后继就是字母表中这个字母的后一个，比如a的后继是b，b的后继是c。而字母表中的最后一个字母是z，为了防止z没有后继，小美又规定z的后继是a。这样字母的后继就形成了一个闭环。
 *
 * 现在小美想要让字符串发生变化。所以他每次会给出一个区间和一个数k，并且让区间中所有的字母变成他们的第k个后继。第k个后继即让后继操作进行k次，比如a的2级后继是c，a的26级后继是a。
 *
 * 现在小美记下来了操作序列和操作完之后得到的字符串。请你还原原来的字符串。
 *
 * ]
 * @Author ANGLE0
 * @Date 2021/4/25 10:17
 * @Version V1.0
 **/

/*

第一行一个长度为n(1≤n≤105)的字符串，代表操作完成之后得到的字符串。

第二行一个数q(1≤q≤105)，代表操作次数。

接下来q行，每行三个数l,r,k(1≤l≤r≤n,1≤k≤109)。代表区间的左右端点和第k级后继。


abcdefg
3
1 3 1
2 4 1
3 5 2




zzyacfg


 */
public class Demo2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String charSeq = scanner.nextLine();

//            System.out.println("input = " + charSeq);

            int n = Integer.parseInt(scanner.nextLine());
            int[][] nums = new int[n][3];

            for (int i = 0; i < nums.length; i++) {
                String line = scanner.nextLine();
                String[] strings = line.split(" ");

                nums[i][0] = Integer.parseInt(strings[0]);
                nums[i][1] = Integer.parseInt(strings[1]);
                nums[i][2] = Integer.parseInt(strings[2]) % 26;

            }

            System.out.println(parse(nums, charSeq));
        }


    }

    private static String parse(int[][] data, String res) {

        // check

        char[] chars = res.toCharArray();

        for (int i = data.length - 1; i >= 0; i--) {

//            System.out.println(data[i][0] + " | " + data[i][1] + " | " + data[i][2]);

            for (int j = data[i][0] - 1; j < data[i][1]; j++) {




                if ((chars[j] - data[i][2]) < 97) {
                    chars[j] = (char)(chars[j] + 26);
                }

                chars[j] = (char)(chars[j] - data[i][2]);

            }

//            for (int j = 0; j < chars.length; j++) {
//                System.out.print(chars[j]);
//            }
//            System.out.println();


        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            builder.append(chars[i]);
        }

        return builder.toString();

    }

}
