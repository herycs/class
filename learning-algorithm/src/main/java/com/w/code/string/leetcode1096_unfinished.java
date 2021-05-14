package com.w.code.string;

import java.util.*;

/**
 * @ClassName leetcode1096
 * @Description [花括号展开]
 * @Author ANGLE0
 * @Date 2020/7/24 9:36
 * @Version V1.0
 **/
public class leetcode1096_unfinished {

    public static void main(String[] args) {
        System.out.println(new leetcode1096_unfinished().braceExpansionII("{a,b}{c,{d,e}}"));
    }

    public List<String> braceExpansionII(String expression) {

        List list = new ArrayList();
        if (expression == null || expression == "") return list;
        list = construct(exp(expression));
        return list;
    }

    //组合
    public List<String> construct(Stack<Character> characters){
        if (characters.empty()) return null;

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        while (!characters.empty()){
            char c = characters.pop();

            if (c != '{' && c != '}')
                list1.add(String.valueOf(c));
            else if (c == '}'){
                while (!characters.empty() && characters.peek() != '{') list1.add(String.valueOf(characters.pop()));
                if (!characters.empty() && characters.peek() == '{') characters.pop();
            }
            System.out.println("-----" + list1);
            if (list2.size() == 0) {
                list2 = list1;
                list1 = new ArrayList<>();
            }else if (list1.size() > 0 && list2.size() > 0)
                list2 = constructList(list1, list2);
        }
        HashSet<String> set = new HashSet<>(list2);
        return new ArrayList<>(set);
    }

    //组合
    public List<String> constructList(List<String> list1, List<String> list2){
        HashSet<String> set = new HashSet();

        ArrayList<String> list = null;
        for (int i = 0; i < list1.size(); i++) {
            list = new ArrayList<>();
            StringBuilder builder = null;

            for (int j = 0; j < list2.size(); j++) {
                builder = new StringBuilder();

                builder.append(list1.get(i));
                builder.append(list2.get(j));
                list.add(builder.toString());
                System.out.println(builder.toString());
            }
        }
        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i));
        }
        list = new ArrayList<>();
        for (String s : set){
            list.add(s);
        }
        return list;
    }

    //拆解字符串到栈中
    public Stack<Character> exp(String exp){
        if (exp == null || exp == "") return null;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) != ',')
                stack.push(exp.charAt(i));
        }
        return stack;
    }
}
