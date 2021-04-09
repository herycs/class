package designPattern.behavior.strategy;

/**
 * @ClassName ConcreteStrategy
 * @Description [具体策略类]
 * @Author ANGLE0
 * @Date 2020/5/1 9:37
 * @Version V1.0
 **/
public class ConcreteStrategyB implements Strategy {

    private String styleName = "飞机";
    private String spendTime = "35min";
    private String sate = "软座";

    @Override
    public void getInto() {
        System.out.println("方式："+styleName+"耗时："+spendTime+"座位："+sate);
    }

    @Override
    public void execute() {
        System.out.println("出发");
        try {
            for (double i = 0; i < 1; i+=0.05d) {
                System.out.printf("当前进程：%.2ff%%\n", i*100);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("到达目的地");
    }
}
