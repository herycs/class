package com.w.dp.create.builder;

/**
 * @ClassName Product
 * @Description [产品模型]
 * @Author ANGLE0
 * @Date 2020/4/29 17:23
 * @Version V1.0
 **/
public class Product {

    private String shell;
    private String hardware;
    private String software;

    public String getShell() {
        return shell;
    }

    public void setShell(String shell) {
        this.shell = shell;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    @Override
    public String toString() {
        return "Product{" +
                "shell='" + shell + '\'' +"\n"+
                ", hardware='" + hardware + '\''+"\n" +
                ", software='" + software + '\''+"\n" +
                '}';
    }
}
