package com.w.SourceCode.thread.other;

/**
 * @ClassName volatileDemo
 * @Description [volatile测试]
 * @Author ANGLE0
 * @Date 2020/6/7 17:26
 * @Version V1.0
 **/
public class volatileDemo {

    /**
     * public JavaBase.SourceCode.thread.other.volatileDemo();
     *     descriptor: ()V
     *     flags: ACC_PUBLIC
     *     Code:
     *       stack=2, locals=1, args_size=1
     *          0: aload_0
     *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
     *          4: aload_0
     *          5: iconst_1
     *          6: putfield      #2                  // Field a:I
     *          9: aload_0
     *         10: iconst_0
     *         11: putfield      #3                  // Field flag:Z
     *         14: return
     *       LineNumberTable:
     *         line 10: 0
     *         line 12: 4
     *         line 13: 9
     * */

    private int a = 1;
    private boolean flag = false;

    public void write(){
        a = 2;
        flag = true;
    }

    /**
     * public void write();
     *     descriptor: ()V
     *     flags: ACC_PUBLIC
     *     Code:
     *       stack=2, locals=1, args_size=1
     *          0: aload_0
     *          1: iconst_2
     *          2: putfield      #2                  // Field a:I
     *          5: aload_0
     *          6: iconst_1
     *          7: putfield      #3                  // Field flag:Z
     *         10: return
     *       LineNumberTable:
     *         line 16: 0
     *         line 17: 5
     *         line 18: 10
     * */

    public void read(){
        if (flag){
            a = 4;
        }
    }
    /**
     * public void read();
     *     descriptor: ()V
     *     flags: ACC_PUBLIC
     *     Code:
     *       stack=2, locals=1, args_size=1
     *          0: aload_0
     *          1: getfield      #3                  // Field flag:Z
     *          4: ifeq          12
     *          7: aload_0
     *          8: iconst_4
     *          9: putfield      #2                  // Field a:I
     *         12: return
     *       LineNumberTable:
     *         line 21: 0
     *         line 22: 7
     *         line 24: 12
     * */

    //常量池和基础信息
    /**
     * Classfile /D:/Wp/wpIdea/DEMO/Base/target/classes/com/w/JavaBase/SourceCode/volatileDemo.class
     *   Last modified 2020-6-7; size 453 bytes
     *   MD5 checksum cf755b26833cb6c25b3f47a1f7d7a265
     *   Compiled from "volatileDemo.java"
     * public class JavaBase.SourceCode.thread.other.volatileDemo
     *   minor version: 0
     *   major version: 52
     *   flags: ACC_PUBLIC, ACC_SUPER
     * Constant pool:
     *    #1 = Methodref          #5.#19         // java/lang/Object."<init>":()V
     *    #2 = Fieldref           #4.#20         // com/w/JavaBase/SourceCode/volatileDemo.a:I
     *    #3 = Fieldref           #4.#21         // com/w/JavaBase/SourceCode/volatileDemo.flag:Z
     *    #4 = Class              #22            // com/w/JavaBase/SourceCode/volatileDemo
     *    #5 = Class              #23            // java/lang/Object
     *    #6 = Utf8               a
     *    #7 = Utf8               I
     *    #8 = Utf8               flag
     *    #9 = Utf8               Z
     *   #10 = Utf8               <init>
     *   #11 = Utf8               ()V
     *   #12 = Utf8               Code
     *   #13 = Utf8               LineNumberTable
     *   #14 = Utf8               write
     *   #15 = Utf8               read
     *   #16 = Utf8               StackMapTable
     *   #17 = Utf8               SourceFile
     *   #18 = Utf8               volatileDemo.java
     *   #19 = NameAndType        #10:#11        // "<init>":()V
     *   #20 = NameAndType        #6:#7          // a:I
     *   #21 = NameAndType        #8:#9          // flag:Z
     *   #22 = Utf8               com/w/JavaBase/SourceCode/volatileDemo
     *   #23 = Utf8               java/lang/Object
     *
     *  }
     * */

}
