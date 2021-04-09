package designPattern.struct.adapter;

import designPattern.struct.adapter.AboutClass.ClassAdapter;
import designPattern.struct.adapter.AboutClass.Target1;
import designPattern.struct.adapter.object.Adaptee;
import designPattern.struct.adapter.object.ObjectAdapter;
import designPattern.struct.adapter.object.Target2;

/**
 * @ClassName Test
 * @Description [测试]
 * @Author ANGLE0
 * @Date 2020/4/29 21:19
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        //类的适配测试
        Target1 target1 = new ClassAdapter();
        target1.work();
        //对象的适配测试
        Target2 target2 = new ObjectAdapter(new Adaptee());
        target2.work();
    }
}
