package designPattern.behavior.command;

/**
 * @ClassName Invoker
 * @Description [调用者]
 * @Author ANGLE0
 * @Date 2020/4/30 20:27
 * @Version V1.0
 **/
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void execude(){
        command.execute();
    }

    public void undo(){
        command.undo();
    }
}
