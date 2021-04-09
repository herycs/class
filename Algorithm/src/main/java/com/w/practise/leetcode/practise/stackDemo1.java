package com.w.practise.leetcode.practise;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName stackDemo1
 * @Description [有效的括号]
 * @Author ANGLE0
 * @Date 2020/4/25 16:16
 * @Version V1.0
 **/
public class stackDemo1 {
    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.nextLine().toCharArray();
        Stack<Character> charStack = new Stack<Character>();

        for (int i = 0; i < chars.length; i++) {
            if (!charStack.empty()) {
                if (isCouple(charStack.pop(), charStack.pop())) {

                }
            }
        }
        return false;
    }

    public boolean isCouple(char s1, char s2){
        if ( ("[").equals(s1) && ("]").equals(s2) ){
            return true;
        }
        if ( ("{").equals(s1) && ("}").equals(s2)){
            return true;
        }
        if ( ("(").equals(s1) && (")").equals(s2)){
            return true;
        }
        return false;
    }

}
