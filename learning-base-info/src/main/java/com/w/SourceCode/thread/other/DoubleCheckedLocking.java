package com.w.SourceCode.thread.other;

/**
 * @ClassName DoubleCheckedLocking
 * @Description [双重检查锁]
 * @Author ANGLE0
 * @Date 2020/6/8 10:02
 * @Version V1.0
 **/
public class DoubleCheckedLocking {

    private DoubleCheckedLocking doubleCheckedLocking;

//    基础判定（多线程情况下存在问题）
    public DoubleCheckedLocking getInstance(){
        if (this.doubleCheckedLocking == null){
            doubleCheckedLocking = new DoubleCheckedLocking();
        }
        return doubleCheckedLocking;
    }

//    双重检查锁（存在问题）
    public DoubleCheckedLocking getInstance2(){
        if (doubleCheckedLocking == null){
            synchronized (DoubleCheckedLocking.class){
                if (doubleCheckedLocking == null){
                    doubleCheckedLocking = new DoubleCheckedLocking();
                }
            }
        }
        /**
         * 执行到此可能存在问题：
         *  1.doubleCheckedLocking可能未初始化结束
         *      类初始化
         *      {
         *          malloc()//分配空间-1
         *          init()//初始化-2
         *          changeRef()//修改指针指向分配空间-3
         *      }
         *      上述，23并无绝对顺序，并且2,3间的重排序并不违反Java语言规范的要求,但此时返回的实例却不是一个正确的实例
         * */
        return doubleCheckedLocking;
    }

//    双重检查锁-优化
    /**
     * 具体操作：使用 volatile 修饰变量，确保其初始化先于instance指针对地址的指向
     * */
    private volatile DoubleCheckedLocking doubleCheckedLocking2;

    public DoubleCheckedLocking getInstance3(){
        if (doubleCheckedLocking2 == null){
            synchronized (DoubleCheckedLocking.class){
                if (doubleCheckedLocking2 == null){
                    doubleCheckedLocking2 = new DoubleCheckedLocking();
                }
            }
        }
        return doubleCheckedLocking2;
    }
}
