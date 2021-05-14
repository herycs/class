package designPattern.struct.flyweight;

/**
 * @ClassName Test
 * @Description [测试]
 * @Author ANGLE0
 * @Date 2020/4/30 16:00
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        Flyweight flyweight = null;

        flyweight = flyweightFactory.getConcreteObj("123");
        flyweight.getReport("共享测试1");

        flyweight = flyweightFactory.getConcreteObj("321");
        flyweight.getReport("共享测试2");

        flyweight = flyweightFactory.getConcreteObj("123");
        flyweight.getReport("共享测试3");

    }
}
