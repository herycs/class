package designPattern.behavior.strategy;

/**
 * @ClassName Context
 * @Description [环境类]
 * @Author ANGLE0
 * @Date 2020/5/1 9:37
 * @Version V1.0
 **/
public class Context {
    private Strategy strategy;

    public Context() {
    }

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void go(){
        this.strategy.execute();
    }
}
