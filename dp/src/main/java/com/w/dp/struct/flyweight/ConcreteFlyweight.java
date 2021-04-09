package designPattern.struct.flyweight;

/**
 * @ClassName ConcreteFlyweight
 * @Description [具体享元类]
 * @Author ANGLE0
 * @Date 2020/4/30 14:40
 * @Version V1.0
 **/
public class ConcreteFlyweight implements Flyweight{

    private String innerState;

    public ConcreteFlyweight(String innerState) {
        this.innerState = innerState;
    }

    @Override
    public void getReport(String state) {
        System.out.println("共享享元对象--->{编号："+this.innerState+", 依据指令："+state+"执行操作}");
    }
}
