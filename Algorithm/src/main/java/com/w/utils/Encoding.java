package com.w.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * @ClassName Encoding
 * @Description [加密解密]
 * @Author ANGLE0
 * @Date 2020/8/21 20:21
 * @Version V1.0
 **/
public class Encoding {

    public static byte[] testMD5(String content) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] utf8s = md5.digest(content.getBytes("utf8"));
        return utf8s;
    }
    public static byte[] testSHA1(String content) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("SHA-1");
        byte[] utf8s = md5.digest(content.getBytes("utf8"));
        return utf8s;
    }

    public static String testBase64(byte[] bytes) {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(bytes);
    }
    public static byte[] testBase64Byte(String base64) throws IOException {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        return base64Decoder.decodeBuffer(base64);
    }

    // 生成DES秘钥
    public static String getKeyDES() throws NoSuchAlgorithmException {
        KeyGenerator des = KeyGenerator.getInstance("DES");
        des.init(56);// 设置秘钥为54位
        SecretKey secretKey = des.generateKey();
        String s = testBase64(secretKey.getEncoded());
        return s;
    }
    // 秘钥转换为Base64格式存储的
    public static SecretKey loadKeyDES(String basse64key) throws IOException {
        byte[] bytes = testBase64Byte(basse64key);
        SecretKey des = new SecretKeySpec(bytes, "DES");
        return des;
    }
    // DES加密
    public static byte[] encryptDES(byte[] source, SecretKey key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher des = Cipher.getInstance("DES");
        des.init(Cipher.ENCRYPT_MODE, key);
        byte[] bytes = des.doFinal(source);
        return bytes;
    }
    // DES解密
    public static byte[] decryptDES(byte[] source, SecretKey key) throws BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher des = Cipher.getInstance("DES");
        des.init(Cipher.DECRYPT_MODE, key);
        byte[] bytes = des.doFinal(source);
        return bytes;
    }

    public static String genKeyAES() throws NoSuchAlgorithmException {
        KeyGenerator aes = KeyGenerator.getInstance("AES");
        aes.init(128); // 128 | 192 | 256
        SecretKey secretKey = aes.generateKey();
        String s = testBase64(secretKey.getEncoded());
        return s;
    }

    private static void print(byte[] bytes) {
        for (byte b : bytes) {
            System.out.print(b);
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            byte[] bytes = testSHA1(line);
            print(bytes);
            System.out.println(BitToHex.bytesToHex(bytes));

            String base64 = testBase64(line.getBytes("utf8"));
            System.out.println(base64);
            System.out.println(testBase64Byte(base64));
        }
    }
}
