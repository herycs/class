package designPattern.struct.bridge;

/**
 * @ClassName ConcreteImplementor
 * @Description [具体实现类]
 * @Author ANGLE0
 * @Date 2020/4/29 22:00
 * @Version V1.0
 **/
public class ConcreteImplementor implements Implementor {
    @Override
    public String decode(String targetType, String filePath) {
        System.out.println("解码完成");
        return null;
    }
}
