package com.w.local.dataStruct.stack;

/**
 * @ClassNameMyStack
 * @Description
 * @Author ANGLE0
 * @Date 2019/12/21 19:45
 * @Version V1.0
 **/
public interface MyStack {
    //初始化栈
    void InitStack();
    //判空
    boolean IsEmpty();
    //入栈
    void Push(Object data);
    //出栈
    Object Pop();
    //获取栈顶元素
    Object GetTop();
    //置空栈
    void SetEmpty();
    //打印栈内元素
    void display();
}
