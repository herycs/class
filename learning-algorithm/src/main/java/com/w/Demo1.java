package com.w;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Demo1
 * @Description []
 * @Author ANGLE0
 * @Date 2021/4/19 10:25
 * @Version V1.0
 **/
public class Demo1 {

    // list  start step | target num

    private List getTargetNums(List<Integer> list, int total, int start, int step) {

        ArrayList<Integer> resList = new ArrayList<>();

        if (list == null || list.size() == 0) return resList;


        // start + step

        // 1 2 3 4 5 6 7
    //  start
        int count = 0;
        int[] flags = new int[list.size()]; // 标记是否取过

        for (int i = start; ; ) {

            if (resList.size() == total || count == list.size()) {
                break;
            }

            if (flags[i % list.size()] == 0) {
                resList.add(list.get(i % list.size()));
                flags[i % list.size() ] = 1;
                i+=step;
                count++;
            } else {
                i++;
            }
        }

        return resList;
    }

}
