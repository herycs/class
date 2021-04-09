package designPattern.behavior.command;

/**
 * @ClassName ConcreteCommand
 * @Description [具体命令类]
 * @Author ANGLE0
 * @Date 2020/4/30 20:27
 * @Version V1.0
 **/
public class ConcreteCommand implements Command{

    private String url = "http://www.baidu.com";
    private Receiver receiver = new Receiver();

    @Override
    public void execute() {
        System.out.println("请求命令发起请求："+url);
        receiver.execute(url);
    }

    @Override
    public void undo() {
        System.out.println("撤销指向："+url+"的请求");
    }
}
