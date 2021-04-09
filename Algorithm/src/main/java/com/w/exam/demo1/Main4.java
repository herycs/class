package com.w.exam.demo1;

import java.util.*;

/**
 * @ClassName Main4
 * @Description [字母排列组合,打印所有顺序]
 * @Author ANGLE0
 * @Date 2020/7/15 20:45
 * @Version V1.0
 **/
public class Main4 {

    List<String> res = new LinkedList<>();
    char[] c = null;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    public void dfs(int index){

        if (index == c.length - 1){
            res.add(String.valueOf(c));
            return ;
        }

        HashSet<Character> set = new HashSet<>();

        for (int i = index; i < c.length; i++) {
            //结果中已经使用了
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            swap(i, index);
            dfs(index + 1);
            swap(i, index);
        }
    }

    public void swap(int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
