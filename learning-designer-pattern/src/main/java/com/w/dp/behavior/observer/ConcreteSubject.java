package designPattern.behavior.observer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ConcreteSubject
 * @Description [具体目标]
 * @Author ANGLE0
 * @Date 2020/4/30 22:12
 * @Version V1.0
 **/
public class ConcreteSubject extends Subject{

    private String state = "wait";
    private Map<String, Observer> map = new HashMap<>();

    @Override
    public void addObserver(String id, Observer observer) {
        if (map.get(id)==null){
            map.put(id, observer);
        }else{
            System.out.println("该观察者者已有实例存在");
        }
    }

    @Override
    public void deleteObserver(String nub) {
        map.remove(nub);
    }

    @Override
    public void notifyObservers(String info) {
        this.setChange(info);
        map.forEach((String, Observer)->{
            System.out.println("消息发送至观察者："+String);
            Observer.update(info);});
    }

    @Override
    public void setChange(String info) {
        this.state = info;
    }
}
