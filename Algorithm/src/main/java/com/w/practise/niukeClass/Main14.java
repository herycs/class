package com.w.practise.niukeClass;

/**
 * @ClassName Main14
 * @Description [字符串交错]
 * @Author ANGLE0
 * @Date 2020/7/26 11:22
 * @Version V1.0
 **/
public class Main14 {
    public boolean chkMixture(String A, int n, String B, int m, String C, int v) {
        if (A.length() + B.length() != C.length()) return false;

        char[] str1 = A.toCharArray();
        char[] str2 = B.toCharArray();
        char[] aim  = C.toCharArray();

        boolean[][] flags = new boolean[str1.length + 1][str2.length + 1];
        flags[0][0] = true;
        // 行
        for (int i = 1; i <= str1.length; i++) {
            if (str1[i - 1] != aim[i - 1]){
                continue;
            }
            flags[i][0] = true;
        }
        // 列
        for (int j = 0; j < str2.length; j++) {
            if (str2[j - 1] != aim[j - 1]){
                continue;
            }
            flags[0][j] = true;
        }

        for (int i = 1; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                if (str1[i - 1] == aim[i + j - 1] && flags[i - 1][j]
                || str2[j - 1] == aim[i + j - 1] &&  flags[i][j - 1]){
                    flags[i][j] = true;
                }
            }
        }
        return flags[str1.length][str2.length];
    }
}
