package com.w.local.dataStruct.stack;

/**
 * @ClassNameStackTest
 * @Description
 * @Author ANGLE0
 * @Date 2019/12/21 20:06
 * @Version V1.0
 **/
public class StackTest {

    public static void main(String[] args) throws Exception {
        LinkedStack linkedStack = new LinkedStack();

        for (int i = 0; i < 10; i++) {
            linkedStack.Push(i+1);
        }
        System.out.println("初始化结束");
        linkedStack.display();
        System.out.println("出栈三次");
        for (int i = 0; i < 3; i++) {
            System.out.println(linkedStack.Pop());
        }
        linkedStack.display();
        System.out.println("入栈二次,1,2");
        for (int i = 0; i < 2; i++) {
            linkedStack.Push(i+1);
        }
        linkedStack.display();
        System.out.println("栈深度");
        System.out.println(linkedStack.size());
        System.out.println("栈置空");
        linkedStack.SetEmpty();
        linkedStack.display();
    }

    private static void BothStackTest() throws Exception {
        BothStack bothStack = new BothStack();

        for (int i = 0; i < 10; i++) {
            bothStack.Push("L", i);
        }
        for (int i = 19; i > 9; i--) {
            bothStack.Push("R", i);
        }
        System.out.println("初始化栈结束");
        inner.show(bothStack);

        System.out.println("左栈弹出三次");
        for (int i = 0; i < 3; i++) {
            System.out.println(bothStack.Pop("L"));
        }
        System.out.println("右栈弹四次");
        for (int i = 0; i < 4; i++) {
            System.out.println(bothStack.Pop("R"));
        }
        inner.show(bothStack);

        System.out.println("左栈入，1,2");
        for (int i = 0; i < 2; i++) {
            bothStack.Push("L", i+1);
        }
        inner.show(bothStack);
        System.out.println("右栈入6,7,8");
        for (int i = 0; i < 3; i++) {
            bothStack.Push("R", i+6);
        }
        inner.show(bothStack);

        System.out.println("置空");
        bothStack.SetEmpty("L");
        bothStack.SetEmpty("R");
        inner.show(bothStack);
    }

    static class inner{
        public static void show(BothStack bothStack){
        System.out.print("总栈:");
        bothStack.display();
        System.out.print("左栈:");
        bothStack.display("L");
        System.out.print("右栈:");
        bothStack.display("R");
    }
    }

    private static void SimpleStckTest() {
        MySeqStack seqStack = new MySeqStack(19);
        for (int i = 0; i < 10; i++) {
            seqStack.Push(i);
        }
        System.out.println("创建完栈");
        seqStack.display();
        System.out.println("出栈三次");
        for (int i = 0; i < 3; i++) {
            System.out.println(seqStack.Pop());
        }
        seqStack.display();
        System.out.println("依次入栈1,2");
        for (int i = 0; i < 2; i++) {
            seqStack.Push(i+1);
        }
        seqStack.display();
        System.out.println("出栈9次，栈空否");
        for (int i = 0; i < 9; i++) {
            System.out.println(seqStack.Pop());
        }
        System.out.println(seqStack.IsEmpty());
        seqStack.display();
    }
}
