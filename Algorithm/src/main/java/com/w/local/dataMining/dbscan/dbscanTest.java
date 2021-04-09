package com.w.local.dataMining.dbscan;

import java.util.ArrayList;

/**
 * @ClassName dbscanTest
 * @Description [测试]
 * @Author ANGLE0
 * @Date 2020/5/18 21:39
 * @Version V1.0
 **/
public class dbscanTest {
    public static void main(String[] args) {
        //生成随机文件
        File file = new File();
        ArrayList list = file.randomData(50, 50);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
//        file.writeDataToFile(list, "oridata.txt");
        //读取文件
        ArrayList arrayList = file.getDataFromFile("oridata.txt");

        DBScan scan = new DBScan(5, 4);

        scan.checkoutCluster(arrayList);

        file.writeresDataToFile(arrayList, "data.txt");
    }
}
