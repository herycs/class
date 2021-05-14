package designPattern.struct.flyweight;

import java.util.List;

/**
 * @ClassName UnsharedConcreteFlyweight
 * @Description [非共享具体享元类]
 * @Author ANGLE0
 * @Date 2020/4/30 14:41
 * @Version V1.0
 **/
public class UnsharedConcreteFlyweight implements Flyweight{

    private String id;
    private List states;

    public UnsharedConcreteFlyweight(List states) {
        this.states = states;
    }

    public List getStates() {
        return states;
    }

    public void setStates(List states) {
        this.states = states;
    }

    @Override
    public void getReport(String state) {
        System.out.print("非共享享元对象--->{编号："+this.id+"为您服务，提供以下支持");
        System.out.println(state+"}");
    }

    public void getReport(){
        System.out.print("编号："+this.id+"为您服务，提供以下支持");
        states.forEach(o -> {
            System.out.println(" "+o);
        });
    }
}
