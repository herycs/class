package com.w.practise.leetcode.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName bigerSubquence
 * @Description [字符序列的较大分组]
 * @Author ANGLE0
 * @Date 2020/5/8 20:41
 * @Version V1.0
 **/
public class bigerSubquence {
    public List<List<Integer>> largeGroupPositions(String S) {

        List list = new ArrayList<int[]>();

        char[] chars = S.toCharArray();
        int len = chars.length;
        int pos = 0;//当前参与比较的字符起始位置
        int count = 0;//字符出现的次数
        for (int i = 0; i < len;) {
            pos = i;
            count = 1;
            while (chars[pos] == chars[i+count]){
                count++;
                if (count + i >= len)break;
            }
            if (count >= 3){
                list.add(new int[]{pos, pos+count-1});
            }
            i = i + count;
        }
        return list;
    }
}
