package designPattern.struct.bridge;

/**
 * @ClassName Abstraction
 * @Description [抽象类]
 * @Author ANGLE0
 * @Date 2020/4/29 21:59
 * @Version V1.0
 **/
public abstract class Abstraction {
    public Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }

    public void readFile(){};
    public void writeFile(){};
    public void player(){}
}
