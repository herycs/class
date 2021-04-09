package designPattern.struct.proxy;

import java.text.SimpleDateFormat;

/**
 * @ClassName Subject
 * @Description [抽象主题角色]
 * @Author ANGLE0
 * @Date 2020/4/30 16:28
 * @Version V1.0
 **/
public class Subject implements Proxy {

    private Proxy proxy = new RealSubject();

    public void preWork(){
        System.out.println("日志：\t时间："+this.getTime()+"状态：即将执行请求");
    }

    @Override
    public void request() {
        this.preWork();
        System.out.println("日志：\t时间："+this.getTime()+"状态：处理请求，发起真实请求");
        proxy.request();
        this.afterWork();
    }

    public void afterWork(){
        System.out.print("日志：\t时间："+this.getTime()+"状态：请求执行完成");
    }

    private String getTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(System.currentTimeMillis());
    }
}
