package designPattern.behavior.mediator;

/**
 * @ClassName ConcreteColleague
 * @Description [具体同事类]
 * @Author ANGLE0
 * @Date 2020/4/30 21:28
 * @Version V1.0
 **/
public class ConcreteColleague implements Colleague {

    private String id;
    private String name;
    private Mediator mediator;

    public ConcreteColleague(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public ConcreteColleague(String id, String name, Mediator mediator) {
        this.id = id;
        this.name = name;
        this.mediator = mediator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ConcreteColleague{" +
                "id='" + id + '\'' +
                ", colleague=" + name +
                '}';
    }

    @Override
    public void receiveTask(String task) {
        System.out.println("接收到任务："+task);
    }

    @Override
    public void sendMsg() {
        System.out.println("任务完成！");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
