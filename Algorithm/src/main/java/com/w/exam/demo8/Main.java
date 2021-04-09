package com.w.exam.demo8;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName Main
 * @Description [demo1]
 * @Author ANGLE0
 * @Date 2020/8/12 20:43
 * @Version V1.0
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        while (n-- > 0) {
            int max = 0;
            int res = 0;
            int m = scanner.nextInt();
            for (int i = 0; i < m; i++) {
                int time = scanner.nextInt();
                int id = scanner.nextInt();
                int state = scanner.nextInt();
                if (map.containsKey(id) && state == 1) {
                    int temp = time - map.get(id);
                    res = temp > max ? id : res;
                    map.put(id, temp);
                } else {
                    map.put(id, time);
                }
            }
            System.out.println(res);
        }
    }

}
/*

1
8
1 1 0
5 2 0
10 3 0
20 3 1
25 4 0
40 4 1
1000 2 1
2000 1 1


1
 */