package com.w.local.dataStruct.linearList.sequence;

import com.w.local.dataStruct.linearList.MyList;

/**
 * @ClassNameArrayList
 * @Description
 * @Author ANGLE0
 * @Date 2019/12/21 13:03
 * @Version V1.0
 **/
public class MyArrayList implements MyList {

    private Object[] elements;

    private int length;

    public MyArrayList(int length) {
        this.elements = new Object[length];
        this.length = 0;
    }

    /**
     * @Desc:  [清空顺序表]
     * @param :  void
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 14:51
     * @version : v1.0
     */
    public void clear() {
        this.length = 0;
    }

    /**
     * @Desc:  [是否为空]
     * @param :  void
     * @return : boolean
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 14:51
     * @version : v1.0
     */
    public boolean isEmpty() {
        return this.length == 0;
    }

    /**
     * @Desc:  [返回当前顺序表的长度]
     * @param :  void
     * @return : int
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 14:50
     * @version : v1.0
     */
    public int length() {
        return this.length;
    }

    /**
     * @Desc:  [返回指定位置数据值]
     * @param :  int
     * @return : Object
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 14:52
     * @version : v1.0
     */
    public Object get(int i) throws Exception {
        if (i < 0 && i > this.length)
            throw new NullPointerException("顺序表中不存在"+i+"位置");
        return elements[i];
    }

    /**
     * @Desc:  [在指定位置插入值,前置插入]
     *          eg:[ 1, 2, 3, 4, 5] ---> insert(2, 0) ---> [1, 0, 2, 3, 4, 5]
     * @param :  int , Object
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 14:59
     * @version : v1.0
     */
    public void insert(int i, Object in) throws Exception {
        //边界判定
        if (i == elements.length)
            throw new Exception("当前表已满，插入失败");
        if (i < 0 || i > elements.length)
            throw new NullPointerException("插入"+i+"位置不合适，数据"+in.toString()+"插入失败");
        //为即将插入的值调整空间
        for (int j = this.length; j > i; j--){
            elements[j] = elements[j-1];
        }
        //赋值修改顺序表元素长度记录
        elements[i] = in;
        this.length++;
    }

    /**
     * @Desc:  [移除当前位置所指向的元素]
     * @param :  int
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 15:17
     * @version : v1.0
     */
    public void remove(int i) throws Exception {
        //边界判定
        if (this.length == 0)
            throw new NullPointerException("顺序表已空");
        if (i > this.length || i < 0)
            throw new NullPointerException("要移除的"+i+"位置不存在");
        //元素左移，覆盖原有值，实现删除
        for (int j = i; j < this.length-1; j++) {
            elements[j] = elements[j+1];
        }
        //修改顺序表长度记录
        this.length--;
    }

    /**
     * @Desc:  [查找指定值在顺序表中的位置]
     * @param :  Object
     * @return : int
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 15:23
     * @version : v1.0
     */
    public int indexOf(Object x) {
        int index = 0;//记录当前扫描位置
        while (index < this.length && !elements[index].equals(x)){
            index++;
        }
        return index < this.length ? index : -1;
    }

    /**
     * @Desc:  [打印顺序表值]
     * @param :  void
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 15:23
     * @version : v1.0
     */
    public void display() {
        System.out.print("[");
        for (int i = 0; i < this.length-1; i++) {
            System.out.print(" "+ elements[i] + ",");
        }
        System.out.print(" "+ elements[this.length-1] + "]\n");
    }
}
