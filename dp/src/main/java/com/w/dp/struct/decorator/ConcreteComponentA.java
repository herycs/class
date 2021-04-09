package com.w.dp.struct.decorator;

/**
 * @ClassName ConcreteComponent
 * @Description [具体构件]
 * @Author ANGLE0
 * @Date 2020/4/30 10:30
 * @Version V1.0
 **/
public class ConcreteComponentA extends Component {

    private String name = "tea";
    private Double price = 7.00;

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public Double price() {
        return this.price;
    }
}
