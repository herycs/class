package com.w.local.dataMining.dbscan;

/**
 * @ClassName Data1
 * @Description [数据类型]
 * @Author ANGLE0
 * @Date 2020/5/18 17:50
 * @Version V1.0
 **/
public class Data1{

    //原始数据对象定义
    class Data{
        private double x;
        private double y;

        public Data(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }
    }

    //原始数据对象
    private Data data;
    private boolean visit;
    private int cluster;
    private boolean noised;

    public Data1(double x, double y) {
        this.data = new Data(x, y);
        this.visit  = false;
        this.cluster = 0;
        this.noised = false;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public boolean isVisit() {
        return visit;
    }

    public void setVisit(boolean visit) {
        this.visit = visit;
    }

    public int getCluster() {
        return cluster;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }

    public boolean isNoised() {
        return noised;
    }

    public void setNoised(boolean noised) {
        this.noised = noised;
    }

    @Override
    public String toString() {
        return "("
                + this.data.getX() +", "
                + this.data.getY()
                +")\t\t\t"
                + this.cluster +"\t"
                + (this.noised == true ? 1 : 0);
    }

    //获取两数据点之间的距离
    public double getDistance(Data1 data1) {
        return Math.sqrt(Math.pow(this.data.x - data1.data.getX(), 2) + Math.pow(this.data.y - data1.data.getY(), 2));
    }
}
