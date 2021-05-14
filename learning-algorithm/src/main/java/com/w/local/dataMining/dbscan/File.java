package com.w.local.dataMining.dbscan;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * @ClassName Data
 * @Description [数据对象]
 * @Author ANGLE0
 * @Date 2020/5/18 17:07
 * @Version V1.0
 **/
public class File {

    //随机数据,num为数据个数，bound为数据的边界
    public static ArrayList<Data1> randomData(int num, int bound) {
        ArrayList<Data1> data1s = new ArrayList<Data1>(num);
        Random rd = new Random(num);
        for (int i = 0; i < num; i++) {
            data1s.add(new Data1(rd.nextInt(bound), rd.nextInt(bound)));
        }
        return data1s;
    }

    //写文件
    public static void writeDataToFile(ArrayList list,String path){
        java.io.File file = new java.io.File(path);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("目标文件不存在，尝试创建失败");
            }
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for (int i = 0; i < list.size(); i++) {
                Data1 data1 = (Data1) list.get(i);
                writer.write(data1.getData().getX()+","+data1.getData().getY()+"\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeresDataToFile(ArrayList list,String path){
        java.io.File file = new java.io.File(path);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("目标文件不存在，尝试创建失败");
            }
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for (int i = 0; i < list.size(); i++) {
                Data1 data1 = (Data1) list.get(i);
                writer.write(data1.getData().getX()+","+data1.getData().getY()+"\t\t"+data1.getCluster()+",\t"+(data1.isNoised() == true ? 1 : 0)+"\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //文件中读取数据
    public static ArrayList getDataFromFile(String path) {
        java.io.File file = new java.io.File(path);
        if (!file.exists()) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("文件不存在");
            }
        }
        return getData(file);
    }

    //解析文件
    public static ArrayList getData(java.io.File file) {
        ArrayList results = new ArrayList<Data1>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String data = null;
            while ((data = reader.readLine()) != null) {
                if (!data.equals("")) {
                    String[] strings = data.split(",");
                    for (int i = 0; i < strings.length; i++) {
                        System.out.println(strings[i]);
                        results.add(new Data1(Double.parseDouble(strings[0]), Double.parseDouble(strings[1])));
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("文件读取异常");
        }
        return results;
    }

}
