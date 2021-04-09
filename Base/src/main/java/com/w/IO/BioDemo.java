package com.w.IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName BioDemo
 * @Description [bio测试]
 * @Author ANGLE0
 * @Date 2020/4/25 10:19
 * @Version V1.0
 **/
public class BioDemo {
    private static byte[] bytes = new byte[100];
    private static int serverPort = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket1 = new ServerSocket();
        try{
            serverSocket1.bind(new InetSocketAddress(serverPort));
            System.out.println("waite conn...");

            //阻塞
            Socket socket = serverSocket1.accept();
            System.out.println("conn success!!!");

            int read = 1;
            while (read > 0){
                read = socket.getInputStream().read(bytes);
                System.out.println("msg coming...");

                String content = new String(bytes);
                System.out.println(">>>"+content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            serverSocket1.close();
        }
    }
}
