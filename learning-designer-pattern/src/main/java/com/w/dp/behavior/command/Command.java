package designPattern.behavior.command;

/**
 * @ClassName Command
 * @Description [命令抽象类]
 * @Author ANGLE0
 * @Date 2020/4/30 19:54
 * @Version V1.0
 **/
public interface Command {
    void execute();
    void undo();
}
