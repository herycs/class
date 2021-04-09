package designPattern.struct.facade;

/**
 * @ClassName Test
 * @Description [测试]
 * @Author ANGLE0
 * @Date 2020/4/30 11:48
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        //facade为平台
        //  用户只需发起购买和卖出的请求，facade依据行情情况选择性购买ABC系统的基金
        Facade facade = new Facade();
        facade.buy();
        facade.sell();
    }
}
