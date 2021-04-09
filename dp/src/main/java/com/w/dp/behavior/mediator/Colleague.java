package designPattern.behavior.mediator;

/**
 * @ClassName Colleague
 * @Description [抽象同事类]
 * @Author ANGLE0
 * @Date 2020/4/30 21:28
 * @Version V1.0
 **/
public interface Colleague {
    void receiveTask(String task);
    void sendMsg();
    void setMediator(Mediator mediator);
}
