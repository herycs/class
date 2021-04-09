package designPattern.behavior.mediator;

/**
 * @ClassName Test
 * @Description [测试]
 * @Author ANGLE0
 * @Date 2020/4/30 21:46
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {

        ConcreteColleague colleague = new ConcreteColleague("001", "财务部");
        ConcreteColleague colleague1 = new ConcreteColleague("010", "市场部");
        ConcreteColleague colleague2 = new ConcreteColleague("011", "技术部");

        Mediator mediator = new ConcreteMediator();

        mediator.register(colleague.getId(), colleague);
        mediator.register(colleague1.getId(), colleague1);
        mediator.register(colleague2.getId(), colleague2);

        mediator.getList();

        mediator.doBusiness("001", "结算本月工资");
        mediator.doBusiness("100", "结算本月工资");

    }
}
