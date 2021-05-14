package designPattern.behavior.observer;

/**
 * @ClassName Test
 * @Description [测试]
 * @Author ANGLE0
 * @Date 2020/4/30 22:34
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        Observer observer1 = new ConcreteObserverA();
        Observer observer2 = new ConcreteObserverB();

        Subject subject = new ConcreteSubject();
        subject.addObserver("CreatingTimer", observer1);
        subject.addObserver("AliveTimer", observer2);

        subject.notifyObservers("createSuccess");
//        subject.notifyObservers("life");
//        subject.notifyObservers("createFailed");
    }
}
