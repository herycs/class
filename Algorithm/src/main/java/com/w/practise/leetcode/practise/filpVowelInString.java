package com.w.practise.leetcode.practise;

/**
 * @ClassName filpVowelInString
 * @Description [翻转字符串中的元音字母]
 * @Author ANGLE0
 * @Date 2020/5/9 10:27
 * @Version V1.0
 **/
public class filpVowelInString {

    public String reverseVowels(String s) {

        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length;

        while (start < end){
            while (!isVowel(chars[start])){
                start++;
            }
            while (!isVowel(chars[end])){
                end--;
            }
            if (start > end){
                break;
            }
            swap(chars, start, end);
            start++;
            end--;
        }
        return chars.toString();
    }

    public static void swap(char[] chars, int i, int j) {
        char s = chars[i];
        chars[i] = chars[j];
        chars[j] = s;
    }

    public static Boolean isVowel(char c) {
        if (c != 'a'|| c != 'o' || c != 'i' || c != 'u' || c != 'e' || c != 'A'|| c != 'O' || c != 'I' || c != 'U' || c != 'E'){
                return false;
        }
        return true;
    }
}
