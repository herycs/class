package com.w.local.dataStruct.stack;

/**
 * @ClassNameMySeqStack
 * @Description
 * @Author ANGLE0
 * @Date 2019/12/21 19:48
 * @Version V1.0
 **/
public class MySeqStack implements MyStack {

    private final int DEFAULT_SIZE = 10;
    private Object[] data;
    private int MAX_SIZE;
    private int top;

    public MySeqStack() {
    }

    public MySeqStack(int top) {
        this.MAX_SIZE = top;
        this.data = new Object[top];
        this.top = -1;
    }

    /**
     * @Desc:  [初始化栈]
     * @param :  void
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 19:54
     * @version : v1.0
     */
    public void InitStack() {
        this.MAX_SIZE = DEFAULT_SIZE;
        this.data = new Object[DEFAULT_SIZE];
        this.top = -1;
    }

    /**
     * @Desc:  [是否为空]
     * @param :  void
     * @return : boolean
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 19:57
     * @version : v1.0
     */
    public boolean IsEmpty() {
        return this.top == -1;
    }

    /**
     * @Desc:  [入栈]
     * @param :  data 入栈值
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 20:05
     * @version : v1.0
     */
    public void Push(Object data) {
        if ( this.top == MAX_SIZE){
            throw new NullPointerException("栈已满,入栈失败");
        }
        this.data[++top] = data;
    }

    /**
     * @Desc:  [出栈]
     * @param :  void
     * @return : Object 弹出值
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 20:05
     * @version : v1.0
     */
    public Object Pop() {
        if (this.top < 0){
            throw new NullPointerException("栈已空，出栈失败");
        }
        return this.data[this.top--];
    }

    /**
     * @Desc:  [获取栈顶元素]
     * @param :  void
     * @return : Object
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 20:06
     * @version : v1.0
     */
    public Object GetTop() {
        return this.IsEmpty() ? null : this.data[top];
    }

    /**
     * @Desc:  [置空栈]
     * @param :  void
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 20:44
     * @version : v1.0
     */
    public void SetEmpty() {
        this.data = null;
        this.top = -1;
    }

    /**
     * @Desc:  [打印栈内所有元素]
     * @param :  void
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 20:44
     * @version : v1.0
     */
    public void display() {
        System.out.print("[");
        if (top != -1) {
            for (int i = 0; i < this.top; i++) {
                System.out.print(" " + this.data[i] + ",");
            }
        System.out.print(" "+this.data[top]);
        }
        System.out.println("]\n");
    }
}
