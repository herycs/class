package designPattern.behavior.observer;

/**
 * @ClassName ConcreteObserver
 * @Description [具体观察者]
 * @Author ANGLE0
 * @Date 2020/4/30 22:13
 * @Version V1.0
 **/
public class ConcreteObserverB extends Observer{
    private Integer integer = 0;

    @Override
    public void update(String info) {
        if (("life").equals(info)){
            this.integer = 1;
        }else if(("dead").equals(info)){
            this.integer = -1;
        }
        System.out.println("观察者B汇报：{被测对象当前存活状态："+integer+"}");
    }
}
