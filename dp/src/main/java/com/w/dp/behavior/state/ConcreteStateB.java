package designPattern.behavior.state;

/**
 * @ClassName ConcreteState
 * @Description [具体状态类]
 * @Author ANGLE0
 * @Date 2020/5/1 9:14
 * @Version V1.0
 **/
public class ConcreteStateB extends State {

    private String stateB = "关";

    @Override
    public void handle(Context context) {
        System.out.println("B--->A");
        context.setState(new ConcreteStateA());
    }

    @Override
    public String toString() {
        return "ConcreteStateB{" +
                "stateB='" + stateB + '\'' +
                '}';
    }
}
