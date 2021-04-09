package designPattern.struct.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FlyweightFactory
 * @Description [享元工厂类]
 * @Author ANGLE0
 * @Date 2020/4/30 14:41
 * @Version V1.0
 **/
public class FlyweightFactory {

    private Map<String, Flyweight> flyweightMap = new HashMap<>();

    public Flyweight getConcreteObj(String state){
        Flyweight flyweight = (Flyweight) flyweightMap.get(state);
        if (flyweight == null){
            flyweight = new ConcreteFlyweight(state);
            flyweightMap.put(state, flyweight);
        }
        return flyweight;
    }
}
