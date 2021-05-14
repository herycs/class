package com.w.dp.struct.decorator;

/**
 * @ClassName ConcreteDecorator
 * @Description [具体装饰类]
 * @Author ANGLE0
 * @Date 2020/4/30 10:30
 * @Version V1.0
 **/
public class ConcreteDecoratorC extends Decorator {

    private Component component = null;
    private String ingredientName = "+珍珠";
    private Double price = 2.00;

    public ConcreteDecoratorC(Component component) {
        this.component = component;
    }

    @Override
    public String name() {
        return this.component.name()+this.ingredientName;
    }

    @Override
    public Double price() {
        return this.component.price()+this.price;
    }
}
