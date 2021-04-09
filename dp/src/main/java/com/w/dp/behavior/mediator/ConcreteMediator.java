package designPattern.behavior.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ConcreteMediator
 * @Description [具体中介者]
 * @Author ANGLE0
 * @Date 2020/4/30 21:28
 * @Version V1.0
 **/
public class ConcreteMediator implements Mediator {

    private Map<String, Colleague> map = new HashMap();

    @Override
    public void register(String ID, Colleague colleague) {
        if (map.get(ID)==null){
            colleague.setMediator(this);
            map.put(ID, colleague);
        }else{
            System.out.println("{id:"+ID+", info:"+colleague+"} have been registered. \nYou can call it by dobusiness("+ID+")");
        }
    }

    @Override
    public void getList() {
        map.forEach((s, colleague) -> {
            System.out.println(s+"\t:\t"+colleague.toString());
        });
    }

    @Override
    public void doBusiness(String target, String info) {
        Colleague colleague = map.get(target);
        if (colleague != null){
            colleague.receiveTask(info);
            colleague.sendMsg();
        }else{
            System.out.println("当前服务暂时终止，请联系客服人员，对您产生的影响我们深表歉意！");
        }
    }

}
