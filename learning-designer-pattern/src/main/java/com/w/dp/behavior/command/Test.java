package designPattern.behavior.command;

/**
 * @ClassName Test
 * @Description [测试]
 * @Author ANGLE0
 * @Date 2020/4/30 20:52
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        Invoker invoker = new Invoker(new ConcreteCommand());
        invoker.execude();
    }
}
