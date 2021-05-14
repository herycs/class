package com.w.local.dataMining.dbscan;

import java.util.ArrayList;

/**
 * @ClassName Dbscan
 * @Description [dbscan算法实现]
 * @Author ANGLE0
 * @Date 2020/5/18 17:05
 * @Version V1.0
 **/
public class DBScan {

    //判定半径
    private double radius;
    //数据量阈值
    private int minPts;
    //初始化
    public DBScan(double radius, int minPts) {
        this.radius = radius;
        this.minPts = minPts;
    }

    //判断是否是全局合法点
    public Boolean isLegalData(ArrayList arrayList) {
        return arrayList.size() > 0 && radius <= arrayList.size();
    }

    //获取当前点为中心点的合法数据
    public ArrayList<Data1> getLegalDatas(Data1 data1, ArrayList<Data1> arrayList) {
        if (data1 == null || arrayList == null) return null;
        //保存与中心点距离[<=redis]的数据点
        ArrayList<Data1> results = new ArrayList();
        for (Data1 tempData : arrayList) {
            if (tempData.getDistance(data1) <= radius) {
                results.add(tempData);
            }
        }
        return results;
    }

    //解析出聚集簇
    public void checkoutCluster(ArrayList<Data1> globalDatas) {
        //结束长度
        int len = globalDatas.size();
        //当前索引
        int index = 0;
        //当前簇类,默认为1,后续簇依次累加簇的类别数
        int cluster = 1;
        //遍历所有排序节点
        while (index < len) {
            //获取数据列表中数据点
            Data1 p = globalDatas.get(index);
            if (!p.isVisit()) {
                p.setVisit(true);
                ArrayList<Data1> pList = getLegalDatas(p, globalDatas);
                //判断当前点是否是干扰点: 范围内数据点[<minPts]即为干扰点
                //当前点不在可选择范围内，排除干扰，修改标志位为干扰点
                if (pList != null && pList.size() < minPts) {
                    p.setNoised(true);
                } else {
                    //当前点是合法点，可为中心
                    //以当前点为中心点建立聚集簇
                    p.setCluster(cluster);
                    //将当前中心点的覆盖范围内的点取出一一评判
                    for (int i = 0; i < pList.size(); i++) {
                        Data1 tempData = pList.get(i);
                        if (!tempData.isVisit()) {
                            tempData.setVisit(true);
                            //获取当前对象的半径范围内的数据点集合
                            //以当前点为基准判断是否符合要求,比对范围全局数据
                            ArrayList<Data1> qList = getLegalDatas(tempData, globalDatas);
                            if (isLegalData(qList)) {
                                //全局范围内是合法点，则将其添加到p的待选集合中
                                pList.addAll(qList);
                            }
                        }
                        //当前数据点还未设置归属簇，则将数据点划分到当前数据点，否则不划分
                        if (tempData.getCluster() == 0) {
                            tempData.setCluster(cluster);
                            if (tempData.isNoised()) {
                                tempData.setNoised(false);
                            }
                        }
                    }
                    cluster++;
                }
            }
            //中心点指针后移1位
            index++;
        }
    }

}
