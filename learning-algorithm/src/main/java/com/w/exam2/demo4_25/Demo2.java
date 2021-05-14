package com.w.exam2.demo4_25;

import java.util.Scanner;

/**
 * @ClassName Demo2
 * @Description [
 *
 * С����һ����Сд��ĸ��ɵ��ַ�����С����Ϊ��ĸ�������˼���������涨����Сд��ĸ�У�ÿ����ĸ�ĺ�̾�����ĸ���������ĸ�ĺ�һ��������a�ĺ����b��b�ĺ����c������ĸ���е����һ����ĸ��z��Ϊ�˷�ֹzû�к�̣�С���ֹ涨z�ĺ����a��������ĸ�ĺ�̾��γ���һ���ջ���
 *
 * ����С����Ҫ���ַ��������仯��������ÿ�λ����һ�������һ����k�����������������е���ĸ������ǵĵ�k����̡���k����̼��ú�̲�������k�Σ�����a��2�������c��a��26�������a��
 *
 * ����С���������˲������кͲ�����֮��õ����ַ��������㻹ԭԭ�����ַ�����
 *
 * ]
 * @Author ANGLE0
 * @Date 2021/4/25 10:17
 * @Version V1.0
 **/

/*

��һ��һ������Ϊn(1��n��105)���ַ���������������֮��õ����ַ�����

�ڶ���һ����q(1��q��105)���������������

������q�У�ÿ��������l,r,k(1��l��r��n,1��k��109)��������������Ҷ˵�͵�k����̡�


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
