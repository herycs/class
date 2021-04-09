package designPattern.behavior.observer;

/**
 * @ClassName Subject
 * @Description [目标]
 * @Author ANGLE0
 * @Date 2020/4/30 22:12
 * @Version V1.0
 **/
public abstract class Subject {
    public void addObserver(String id, Observer observer){};
    public void deleteObserver(String nub){};
    public void notifyObservers(String info){};
    public void setChange(String info){};
}
