package com.w.local.dataMining.apriori;

import java.util.*;

/**
 * @ClassName testDemo
 * @Description [测试]
 * @Author ANGLE0
 * @Date 2020/4/29 11:27
 * @Version V1.0
 **/
public class testDemo {

    public static void main(String[] args) {

        String splitChar = ";";
        String dataBuffer = "";
        String[] dataElements = null;
        HashSet<String> elements = new HashSet<String>();

        Scanner input = new Scanner(System.in);
        dataBuffer = input.nextLine();
        while(!dataBuffer.equals("-1")){
            dataBuffer = input.nextLine();

            dataElements = dataBuffer.split(splitChar);
            for (int i = 0; i < dataElements.length; i++) {
                elements.add(dataElements[i]);
            }
        }

        List list = Arrays.asList(elements.toArray());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
