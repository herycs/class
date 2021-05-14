package designPattern.behavior.mediator;

/**
 * @ClassName Mediator
 * @Description [抽象中介者]
 * @Author ANGLE0
 * @Date 2020/4/30 21:27
 * @Version V1.0
 **/
public interface Mediator {
    void register(String ID, Colleague colleague);
    void getList();
    void doBusiness(String target, String info);
}
