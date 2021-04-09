package com.w.dp.struct.decorator;

/**
 * @ClassName Test
 * @Description [测试]
 * @Author ANGLE0
 * @Date 2020/4/30 10:45
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        //选取原对象
        Component component = new ConcreteComponentA();
        component = new ConcreteDecoratorA(component);
        System.out.println("产品："+component.name()+", 价格："+component.price());

        component = new ConcreteDecoratorB(component);
        System.out.println("产品："+component.name()+", 价格："+component.price());

        Component component1 = new ConcreteComponentB();
        component1 = new ConcreteDecoratorA(component1);
        component1 = new ConcreteDecoratorC(component1);
        System.out.println("产品："+component1.name()+", 价格："+component1.price());

    }
}
