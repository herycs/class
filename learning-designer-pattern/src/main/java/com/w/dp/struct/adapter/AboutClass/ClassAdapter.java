package designPattern.struct.adapter.AboutClass;

/**
 * @ClassName Adapter
 * @Description [适配器类]
 * @Author ANGLE0
 * @Date 2020/4/29 21:05
 * @Version V1.0
 **/
public class ClassAdapter extends Adaptee implements Target1 {
    public void request(){
        //执行目标适配者的方法
        super.localRequest();
    }

    @Override
    public void work() {
        //为client提供发起请求的方法
        System.out.println("适配器的work方法触发了");
        this.request();
    }
}
