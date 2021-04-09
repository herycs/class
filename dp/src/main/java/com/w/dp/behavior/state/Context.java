package designPattern.behavior.state;

/**
 * @ClassName Context
 * @Description [环境类]
 * @Author ANGLE0
 * @Date 2020/5/1 9:13
 * @Version V1.0
 **/
public class Context {
    private State state = null;

    public Context(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void doit(){
        this.state.handle(this);
    }

    @Override
    public String toString() {
        return "Context{" +
                "state=" + this.state.toString() +
                '}';
    }
}
