package designPattern.behavior.state;

/**
 * @ClassName ConcreteState
 * @Description [具体状态类]
 * @Author ANGLE0
 * @Date 2020/5/1 9:14
 * @Version V1.0
 **/
public class ConcreteStateA extends State {
    private String stateA = "开";

    @Override
    public void handle(Context context) {
        System.out.println("A--->B");
        context.setState(new ConcreteStateB());
    }

    @Override
    public String toString() {
        return "ConcreteStateA{" +
                "stateA='" + stateA + '\'' +
                '}';
    }
}
