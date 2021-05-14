package designPattern.struct.adapter.object;

/**
 * @ClassName ObjectAdapter
 * @Description [对象适配器]
 * @Author ANGLE0
 * @Date 2020/4/29 21:41
 * @Version V1.0
 **/
public class ObjectAdapter implements Target2 {

    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void work() {
        adaptee.localRequest();
    }
}
