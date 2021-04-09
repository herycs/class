package designPattern.behavior.state;

/**
 * @ClassName Test
 * @Description [测试]
 * @Author ANGLE0
 * @Date 2020/5/1 9:25
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteStateA());
        System.out.println(context.toString());
        context.doit();
        System.out.println(context.toString());
        context.doit();
        System.out.println(context.toString());
    }
}
