package com.w.SourceCode.thread.other;

/**
 * @ClassName volatileDemo2
 * @Description [volatileDemo]
 * @Author ANGLE0
 * @Date 2020/6/7 17:38
 * @Version V1.0
 **/
public class volatileDemo2 {

    volatile private int a = 1;
    volatile private boolean flag = false;

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
}
