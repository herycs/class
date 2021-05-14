package designPattern.struct.bridge;

/**
 * @ClassName Test
 * @Description [测试]
 * @Author ANGLE0
 * @Date 2020/4/29 22:14
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        Abstraction abstraction = new RefinedAbstraction(new ConcreteImplementor());
        abstraction.implementor.decode("123","123");
        abstraction.player();
    }
}
