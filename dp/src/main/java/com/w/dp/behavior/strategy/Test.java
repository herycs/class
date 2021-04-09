package designPattern.behavior.strategy;

/**
 * @ClassName Test
 * @Description [测试]
 * @Author ANGLE0
 * @Date 2020/5/1 9:48
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        Context context = new Context();

        context.setStrategy(new ConcreteStrategyA());
        context.getStrategy().getInto();
        context.go();

        context.setStrategy(new ConcreteStrategyB());
        context.getStrategy().getInto();
        context.go();
    }
}
