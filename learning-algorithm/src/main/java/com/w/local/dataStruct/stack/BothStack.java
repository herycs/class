package com.w.local.dataStruct.stack;

/**
 * @ClassNameBothStack
 * @Description
 * @Author ANGLE0
 * @Date 2019/12/21 20:46
 * @Version V1.0
 **/
public class BothStack {

    private int DEFAULT_DEEP = 20;//默认栈大小
    private int MAX_SIZE;//自定义的栈的最大值
    private Object[] data;//元素顺序表
    private int leftTop;//左栈顶
    private int rightTop;//右栈顶

    public BothStack() {
        this.InitStack();
    }

    public BothStack(int totalLength) {
        this.MAX_SIZE = totalLength;
        this.data = new Object[this.MAX_SIZE];
        this.leftTop = -1;
        /*
            此处不加1是因为操作的是索引，其最大值就是栈的最右端加一
            this.rightTop = MAX_SIZE + 1;
         */
        this.rightTop = MAX_SIZE;
    }

    public void InitStack() {
        this.data = new Object[DEFAULT_DEEP];
        this.MAX_SIZE = DEFAULT_DEEP;
        this.leftTop = -1;
        this.rightTop = DEFAULT_DEEP;
    }

    /**
     * @param : void
     * @return : void
     * @Desc: [判全栈是否为空]
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 21:16
     * @version : v1.0
     */
    public boolean IsEmpty() {
        return leftTop == -1 && rightTop == MAX_SIZE;
    }

    /**
     * @param : String
     * @return : boolean
     * @Desc: [判断指定栈是否为空]
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 21:18
     * @version : v1.0
     */
    public boolean IsEmpty(String stack) {
        if (stack.equals("L") && this.leftTop == -1) {
            return true;
        }
        return stack.equals("R") && this.rightTop == MAX_SIZE;
    }

    /**
     * @Desc:  [向栈内压入元素]
     * @param :  stack --- 操作栈[R: 右栈，L：左栈]， data --- 压入元素值
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/22 0:39
     * @version : v1.0
     */
    public void Push(String stack, Object data) throws Exception {
        if (this.leftTop + 1 == this.rightTop)
            throw new Exception("栈已满,入栈失败");
        if (stack.equals("L")) {
            this.data[++leftTop] = data;
        } else if (stack.equals("R")) {
            this.data[--rightTop] = data;
        } else {
            throw new Exception("命令错误");
        }
    }

    /**
     * @Desc:  [弹出栈顶元素]
     * @param :  stack --- 操作栈[R: 右栈，L：左栈]
     * @return : Object
     * @author :  ANGLE0
     * @createTime ：  2019/12/22 0:39
     * @version : v1.0
     */
    public Object Pop(String stack) throws Exception {
        this.IsEmpty();
        //取左栈元素
        if (stack.equals("L")) {
            //左栈非空
            if (!IsEmpty(stack))
                return this.data[leftTop--];
            throw new Exception("左栈已空");
            //取又栈元素
        } else if (stack.equals("R")) {
            //右栈非空
            if (!IsEmpty(stack))
                return this.data[rightTop++];
            throw new Exception("右栈已空");
        } else {
            throw new Exception("命令错误");
        }
    }

    /**
     * @param : stack --- 操作栈[R: 右栈，L：左栈]
     * @return : Object
     * @Desc: [获取栈顶元素值]
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 22:59
     * @version : v1.0
     */
    public Object GetTop(String stack) throws Exception {
        //取左栈元素
        if (stack.equals("L")) {
            //左栈非空
            if (!IsEmpty(stack))
                return this.data[leftTop];
            throw new Exception("左栈已空");
            //取右栈元素
        } else if (stack.equals("R")) {
            //右栈非空
            if (!IsEmpty(stack))
                return this.data[rightTop];
            throw new Exception("右栈已空");
        } else {
            throw new Exception("命令错误");
        }
    }

    /**
     * @param : void
     * @return : void
     * @Desc: [置空全栈元素]
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 23:58
     * @version : v1.0
     */
    public void SetEmpty() {
        this.data = null;
        this.leftTop = -1;
        this.rightTop = this.MAX_SIZE;
    }

    /**
     * @param : stack --- 操作栈[R: 右栈，L：左栈]
     * @return : void
     * @Desc: [置空左或者右栈]
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 23:58
     * @version : v1.0
     */
    public void SetEmpty(String stack) throws Exception {
        if (stack.equals("L"))
            this.leftTop = -1;
        else if (stack.equals("R"))
            this.rightTop = MAX_SIZE;
        else
            throw new Exception("命令错误，置空失败");
    }

    /**
     * @param : void
     * @return : void
     * @Desc: [打印全栈元素]
     * # --- 表示空元素
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 23:57
     * @version : v1.0
     */
    public void display() {
        System.out.print("[");
        if (!this.IsEmpty()) {
            for (int i = 0; i < this.MAX_SIZE - 1; i++) {
                if (i > this.leftTop && i < this.rightTop) {
                    System.out.print(" " + "#" + ",");
                } else {
                    System.out.print(" " + this.data[i] + ",");
                }
            }
            //打印最后一个元素
            System.out.print(" " + this.data[this.MAX_SIZE - 1]);
        }
        System.out.println("]\n");

    }

    /**
     * @Desc:  [打印指定栈的元素]
     * @param :  stack --- 操作栈[R: 右栈，L：左栈]
     * @return :
     * @author :  ANGLE0
     * @createTime ：  2019/12/22 0:43
     * @version : v1.0
     */
    public void display(String stack) {
        int start = 0;
        int end = MAX_SIZE;

        if (this.IsEmpty()) {
            start = 0;
            end = 0;
        } else if (stack.equals("L") && !this.IsEmpty(stack)) {
            //指令打印左栈且左栈非空
            end = this.leftTop;
            start = 0;
            //指令打印右栈且右栈非空
        } else if (stack.equals("R") && !this.IsEmpty(stack)) {
            start = this.rightTop;
            end = MAX_SIZE - 1;
        }

        //正式打印
        System.out.print("[");
        if (!this.IsEmpty()) {
            for (int i = start; i < end; i++) {
                System.out.print(" " + this.data[i] + ",");
            }
            System.out.print(" " + this.data[end]);
        }
        System.out.println("]\n");

    }
}
