package com.w.dp.create.builder;

/**
 * @ClassName Director
 * @Description [指挥者]
 * @Author ANGLE0
 * @Date 2020/4/29 17:31
 * @Version V1.0
 **/
public class Director {

    private Builder builder;

    public Director() {
    }

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product construct(){
        builder.buildShell();
        builder.buildHardWare();
        builder.buildSoftWare();
        return (Product) builder.getResult();
    }

    public void setBuilder(Builder builder){
        this.builder = builder;
    }
}
