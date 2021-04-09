package com.w.SourceCode.thread.other;

/**
 * @ClassName SyncDemo
 * @Description [Sync...关键字]
 * @Author ANGLE0
 * @Date 2020/6/7 10:45
 * @Version V1.0
 **/
public class SyncDemo {

    public synchronized void testM() {
        System.out.println("method");
    }

    public synchronized static void testS() {
        System.out.println("static method");
    }

    public void testC() {
        synchronized (this) {
            System.out.println("class");
        }
    }

    //javap -c | javap -v
    /**
     *
     * Classfile /D:/Wp/wpIdea/DEMO/Base/target/classes/com/w/JavaBase/SourceCode/SyncDemo.class
     *    Last modified 2020-6-7; size 678 bytes
     *   MD5 checksum 98fd380f05b9c39195c411bc9d8ceea5
     *   Compiled from "SyncDemo.java"
     * public class JavaBase.SourceCode.thread.other.SyncDemo
     *   minor version: 0
     *   major version: 52
     *   flags: ACC_PUBLIC, ACC_SUPER
     * Constant pool:
     *    #1 = Methodref          #8.#22         // java/lang/Object."<init>":()V
     *    #2 = Fieldref           #23.#24        // java/lang/System.out:Ljava/io/PrintStream;
     *    #3 = String             #25            // method
     *    #4 = Methodref          #26.#27        // java/io/PrintStream.println:(Ljava/lang/String;)V
     *    #5 = String             #28            // static method
     *    #6 = String             #29            // class
     *    #7 = Class              #30            // com/w/JavaBase/SourceCode/SyncDemo
     *    #8 = Class              #31            // java/lang/Object
     *    #9 = Utf8               <init>
     *   #10 = Utf8               ()V
     *   #11 = Utf8               Code
     *   #12 = Utf8               LineNumberTable
     *   #13 = Utf8               testM
     *   #14 = Utf8               testS
     *   #15 = Utf8               testC
     *   #16 = Utf8               StackMapTable
     *   #17 = Class              #30            // com/w/JavaBase/SourceCode/SyncDemo
     *   #18 = Class              #31            // java/lang/Object
     *   #19 = Class              #32            // java/lang/Throwable
     *   #20 = Utf8               SourceFile
     *   #21 = Utf8               SyncDemo.java
     *   #22 = NameAndType        #9:#10         // "<init>":()V
     *   #23 = Class              #33            // java/lang/System
     *   #24 = NameAndType        #34:#35        // out:Ljava/io/PrintStream;
     *   #25 = Utf8               method
     *   #26 = Class              #36            // java/io/PrintStream
     *   #27 = NameAndType        #37:#38        // println:(Ljava/lang/String;)V
     *   #28 = Utf8               static method
     *   #29 = Utf8               class
     *   #30 = Utf8               com/w/JavaBase/SourceCode/SyncDemo
     *   #31 = Utf8               java/lang/Object
     *   #32 = Utf8               java/lang/Throwable
     *   #33 = Utf8               java/lang/System
     *   #34 = Utf8               out
     *   #35 = Utf8               Ljava/io/PrintStream;
     *   #36 = Utf8               java/io/PrintStream
     *   #37 = Utf8               println
     *   #38 = Utf8               (Ljava/lang/String;)V
     * {
     *   public JavaBase.SourceCode.thread.other.SyncDemo();
     *     descriptor: ()V
     *     flags: ACC_PUBLIC
     *     Code:
     *       stack=1, locals=1, args_size=1
     *          0: aload_0
     *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
     *          4: return
     *       LineNumberTable:
     *         line 10: 0
     *
     *   public synchronized void testM();
     *     descriptor: ()V
     *     flags: ACC_PUBLIC, ACC_SYNCHRONIZED
     *     Code:
     *       stack=2, locals=1, args_size=1
     *          0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *          3: ldc           #3                  // String method
     *          5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *          8: return
     *       LineNumberTable:
     *         line 13: 0
     *         line 14: 8
     *
     *   public static synchronized void testS();
     *     descriptor: ()V
     *     flags: ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
     *     Code:
     *       stack=2, locals=0, args_size=0
     *          0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *          3: ldc           #5                  // String static method
     *          5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *          8: return
     *       LineNumberTable:
     *         line 17: 0
     *         line 18: 8
     *
     *   public void testC();
     *     descriptor: ()V
     *     flags: ACC_PUBLIC
     *     Code:
     *       stack=2, locals=3, args_size=1
     *          0: aload_0
     *          1: dup
     *          2: astore_1
     *          3: monitorenter
     *          4: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *          7: ldc           #6                  // String class
     *          9: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *         12: aload_1
     *         13: monitorexit
     *         14: goto          22
     *         17: astore_2
     *         18: aload_1
     *         19: monitorexit
     *         20: aload_2
     *         21: athrow
     *         22: return
     *       Exception table:
     *          from    to  target type
     *              4    14    17   any
     *             17    20    17   any
     *       LineNumberTable:
     *         line 21: 0
     *         line 22: 4
     *         line 23: 12
     *         line 24: 22
     *       StackMapTable: number_of_entries = 2
     *          frame_type = 255 /* full_frame
     *              offset_delta =17
     *              locals =[class com/w/JavaBase/SourceCode/SyncDemo,class java/lang/Object ]
     *              stack =[class java/lang/Throwable ]
     *          frame_type =250 /* chop
     *              offset_delta =4
     *       }
     *
     */

}
