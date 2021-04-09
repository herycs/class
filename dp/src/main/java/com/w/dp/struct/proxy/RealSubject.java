package designPattern.struct.proxy;

/**
 * @ClassName RealSubject
 * @Description [真实主题角色]
 * @Author ANGLE0
 * @Date 2020/4/30 16:29
 * @Version V1.0
 **/
public class RealSubject implements Proxy {

    @Override
    public void request() {
        System.out.println("请求已发往服务器");
    }
}
