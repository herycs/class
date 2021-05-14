package designPattern.struct.proxy;

/**
 * @ClassName Test
 * @Description [测试]
 * @Author ANGLE0
 * @Date 2020/4/30 16:37
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        Proxy proxy = new Subject();
        proxy.request();
    }
}
