package designPattern.struct.adapter.AboutClass;

/**
 * @ClassName Adaptee
 * @Description [适配者]
 * @Author ANGLE0
 * @Date 2020/4/29 21:05
 * @Version V1.0
 **/
public abstract class Adaptee {
    void localRequest(){
        System.out.println("适配者发起请求");
    }
}
