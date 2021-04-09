package designPattern.struct.bridge;

/**
 * @ClassName RefinedAbstraction
 * @Description [扩充抽象类]
 * @Author ANGLE0
 * @Date 2020/4/29 22:00
 * @Version V1.0
 **/
public class RefinedAbstraction extends Abstraction {

    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void writeFile() {
        super.writeFile();
    }

    @Override
    public void readFile() {
        super.readFile();
    }

    @Override
    public void player() {
        //设定解码类型
        System.out.println("平台1播放器播放");
        super.player();
    }
}
