package com.w.dp.create.builder;

/**
 * @ClassName ConcreateBuilder
 * @Description [具体建造者]
 * @Author ANGLE0
 * @Date 2020/4/29 17:21
 * @Version V1.0
 **/
public class ConcreateBuilder extends Builder<Product>{

    private Product product = new Product();

    void buildShell() {
        this.product.setShell("金属外壳");
    }

    void buildHardWare() {
        this.product.setHardware("CPU:i9-9300, GTX 2080ti, 内存：32G, 256G SSD, IPS 75%, 显示：2K");
    }

    void buildSoftWare() {
        this.product.setSoftware("MAC OS");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
