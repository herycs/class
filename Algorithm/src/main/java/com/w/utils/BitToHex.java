package com.w.utils;

/**
 * @ClassName BitToHex
 * @Description [2进制&16进制转换]
 * @Author ANGLE0
 * @Date 2020/8/21 18:45
 * @Version V1.0
 **/
public class BitToHex {
    public static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];

            boolean negative = b < 0 ? true : false;
            int num = Math.abs(b);
            if (negative) num = num | 0x80;

            String temp = Integer.toHexString(num & 0xFF);
            if (temp.length() == 1) {
                builder.append("0");
            }
            builder.append(temp.toLowerCase());
        }
        return builder.toString();
    }
    public static String hexToBytes(String hex) {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length(); i+=2) {
            String substring = hex.substring(i, i + 2);

            boolean negative = false;
            int inte = Integer.parseInt(substring, 16);
            if (inte > 127) negative = true;
            if (inte == 128) inte = -128;
            else if (negative) inte = 0 - (inte & 0x7F);

            byte b = (byte) inte;
            bytes[i / 2] = b;
        }
        return bytes.toString();
    }

    public static void main(String[] args) {

        byte n = (byte) 1010_1101;

        int num = n | 0x80;
        System.out.println(Integer.toHexString(num & 0xFF));
//        ed

        System.out.println(Integer.toHexString(n & 0xFF));
//        6d, 1010减一-》1001-》取反得到源码 0110--》6
    }
}
