package com.w.exam.demo24;

import java.util.*;

/**
 * @ClassName Main
 * @Description [携程]
 * @Author ANGLE0
 * @Date 2020/9/8 19:07
 * @Version V1.0
 **/
public class Main {
    private static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] s = scanner.nextLine().split(" ");
            char[] res = new char[s.length];
            LinkedList<Character> list = new LinkedList<>();
            getCharCompose(list, s, 0);
            for (String sss : set) {
                System.out.println(sss.replace("#", "--circular dependency"));
            }
        }
    }
    public static void getCharCompose(LinkedList linkedList, String[] s, int index) {
        if (index > s.length) return;
        if (index == s.length) {
            if (linkedList.getFirst() == "#") {
                linkedList.removeFirst();
                linkedList.addLast("#");
            }
            set.add(String.valueOf(linkedList.toArray()));
        }
        if (index < s.length ) {
            String ss = s[index];
            linkedList.addLast(s[0]);
            for (int i = 1; i < ss.length(); i++) {
                if (linkedList.contains(ss.charAt(i))) {
                    linkedList.addFirst("#");
                }
                linkedList.removeLast();
                linkedList.addLast(ss.charAt(i));
                getCharCompose(linkedList, s, index + 1);
            }
        }
    }
}
/*
a bc d eag f

abdef
abdaf--circular dependency
abdgf
acdef
acdaf--circular dependency
acdgf
 */