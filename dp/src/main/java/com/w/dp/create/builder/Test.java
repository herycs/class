package com.w.dp.create.builder;

/**
 * @ClassName Test
 * @Description [测试]
 * @Author ANGLE0
 * @Date 2020/4/29 19:15
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        Director director = new Director(new ConcreateBuilder());
        Product p = director.construct();
        System.out.println(p.toString());
    }
}
