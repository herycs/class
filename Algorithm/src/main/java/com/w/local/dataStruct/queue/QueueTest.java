package com.w.local.dataStruct.queue;

/**
 * @ClassNameQueueTest
 * @Description
 * @Author ANGLE0
 * @Date 2019/12/22 15:03
 * @Version V1.0
 **/
public class QueueTest {
    public static void main(String[] args) throws Exception {
        LinkedQueue linkedQueue = new LinkedQueue();
        for (int i = 0; i < 10; i++) {
            linkedQueue.InQueue(i+1);
        }
        System.out.println("队列初始化结束");
        linkedQueue.display();
        System.out.println("出队列三次");
        for (int i = 0; i < 3; i++) {
            System.out.println(linkedQueue.OutQueue());
        }
        linkedQueue.display();
        System.out.println("入队列两次");
        for (int i = 0; i < 2; i++) {
            linkedQueue.InQueue(i+1);
        }
        linkedQueue.display();
        System.out.println("队列为空否"+linkedQueue.EmptyQueue());
    }

    private static void SeqQueueTest() throws Exception {
        SeqQueue seqQueue = new SeqQueue();

        for (int i = 0; i < 7; i++) {
            seqQueue.InQueue(i+1);
        }
        System.out.println("初始化队列成功");
        seqQueue.display();
        System.out.println("出队列三次");
        for (int i = 0; i < 3; i++) {
            System.out.println(seqQueue.OutQueue());
        }
        seqQueue.display();
        System.out.println("入队列两次");
        for (int i = 0; i < 2; i++) {
            seqQueue.InQueue(i+1);
        }
        seqQueue.display();
        System.out.println("队头值"+seqQueue.FrontQueue());
        System.out.println("队列是否为空"+seqQueue.EmptyQueue());
        System.out.println("入队5次");
        for (int i = 0; i < 5; i++) {
            seqQueue.InQueue(i+1);
        }
        seqQueue.display();
    }
}
