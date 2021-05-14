package designPattern.behavior.observer;

/**
 * @ClassName ConcreteObserver
 * @Description [具体观察者]
 * @Author ANGLE0
 * @Date 2020/4/30 22:13
 * @Version V1.0
 **/
public class ConcreteObserverA extends Observer{

    private Integer integer = 0;

    @Override
    public void update(String info) {
        if (("createSuccess").equals(info)){
            this.integer = 1;
        }else if(("createFailed").equals(info)){
            this.integer = -1;
        }
        System.out.println("观察者A汇报：{被测对象创建状态："+integer+"}");
    }
}
