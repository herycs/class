package com.w.exam2.demo4_25;

import com.mysql.cj.log.LogFactory;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import java.util.Scanner;

/**
 * @ClassName Demo1
 * @Description [√¿Õ≈]
 * @Author ANGLE0
 * @Date 2021/4/25 10:17
 * @Version V1.0
 **/
public class Demo1 {

    private static Logger logger = LoggerFactory.logger(Demo1.class);

    // A : 65 Z: 90
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String nextLine = scanner.nextLine();
//            String[] strings = nextLine.split(" ");
//            int n = Integer.parseInt(strings[0]);
//            int seq = Integer.parseInt(strings[1]);
//
//            int[] nums = new int[n];
//            for (int i = 0; i < nums.length; i++) {
//                nums[i] = scanner.nextInt();
//
//                int charSeq = nums[i] / seq;
//                int littleSeq = nums[i] % seq;
//
//                if (littleSeq == 0) {
//                    charSeq--;
//                    littleSeq = seq;
//                }
//
//                System.out.print((char)(65 + charSeq));
//                System.out.println(littleSeq);
//
//
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println((char)((26 + 'a') - 1));
        System.out.println();
    }

}
/*

5 5
71
28
120
30
1


 */