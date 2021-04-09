package designPattern.struct.facade;

/**
 * @ClassName Facade
 * @Description [外观角色]
 * @Author ANGLE0
 * @Date 2020/4/30 11:33
 * @Version V1.0
 **/
public class Facade {

    private SubSystemA subSystemA = new SubSystemA();
    private SubSystemB subSystemB = new SubSystemB();
    private SubSystemC subSystemC = new SubSystemC();
    private int choice = 1;

    public void buy(){
        switch (choice){
            case 1:
                subSystemA.buy();
                break;
            case 2:
                subSystemB.buy();
                break;
            case 3:
                subSystemC.buy();
                break;
            default:
                System.out.println("buy nothing");
                break;
        }
    }
    public void sell(){
        switch (choice){
            case 1:
                subSystemA.sell();
                break;
            case 2:
                subSystemB.sell();
                break;
            case 3:
                subSystemC.sell();
                break;
            default:
                System.out.println("sell nothing");
                break;
        }
    }

}
