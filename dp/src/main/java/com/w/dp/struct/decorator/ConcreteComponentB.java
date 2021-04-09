package com.w.dp.struct.decorator;

/**
 * @ClassName ConcreteComponentB
 * @Description [具体组件类B]
 * @Author ANGLE0
 * @Date 2020/4/30 10:37
 * @Version V1.0
 **/
public class ConcreteComponentB extends Component{

    private String name = "coffee";
    private Double price = 14.00;

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public Double price() {
        return this.price;
    }
}
