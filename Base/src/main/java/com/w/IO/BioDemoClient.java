package com.w.IO;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @ClassName BioDemoClient
 * @Description [bio client]
 * @Author ANGLE0
 * @Date 2020/4/25 10:24
 * @Version V1.0
 **/
public class BioDemoClient {
    private static int port = 8080;
    private static String ip = "127.0.0.1";


    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(ip,port);
        StringBuffer buffer = new StringBuffer("hi,");
        int times = 5;
        try{
            while (times-- > 0){
                Thread.sleep(1000);
                System.out.println("No."+times+"_msg: Send Success");
                buffer.append(times);
                socket.getOutputStream().write(buffer.toString().getBytes());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
}
