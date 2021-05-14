package com.w.local.dataStruct.linearList.sequence;

import java.util.Arrays;

/**
 * @ClassNameSeqList
 * @Description 泛化顺序表
 * @Author ANGLE0
 * @Date 2019/12/21 15:28
 * @Version V1.0
 **/
public class SeqList<T> {

    private int DEFAULT_SIZE = 2;//默认表长度
    private Object[] elementData;//元素值
    private int length;//当前表长度
    private int size = 0;//当前元素个数

    /**
     * @Desc:  [构造默认长度顺序表]
     * @param :  void
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 15:30
     * @version : v1.0
     */
    public SeqList() {
        length = DEFAULT_SIZE;
        elementData = new Object[length];
    }
    
    /**
     * @Desc:  [带参初始化]
     * @param :  T
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 15:32
     * @version : v1.0
     */
    public SeqList(T element) {
        this();
        elementData[0] = element;
        size++;
    }
    
    /**
     * @Desc:  [带参初始化]
     * @param :  T, int 
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 15:32
     * @version : v1.0
     */
    public SeqList(T element, int initSize) {
        length = 1;
        if (length < initSize) {
            length = initSize + 2;
        }
        elementData = new Object[length];
        elementData[0] = element;
        size++;
    }

    /**
     * @Desc:  [insert操作]
     * @param :  T, int
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 15:33
     * @version : v1.0
     */
    public void insert(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数组越界异常");
        }
        ensurelength(size + 1);
        //把index以后的元素都后移一位
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    /**
     * @Desc:  [获取长度]
     * @param :  void
     * @return : int
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 15:34
     * @version : v1.0
     */
    public int length() {
        return size;
    }

    /**
     * @Desc:  [add操作]
     * @param :  T
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 15:34
     * @version : v1.0
     */
    public void add(T element) {
        insert(element, size);
    }

   /**
    * @Desc:  [读取指定位置元素值]
    * @param :  int
    * @return : T
    * @author :  ANGLE0
    * @createTime ：  2019/12/21 15:35
    * @version : v1.0
    */
    public T get(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("数组越界异常");
        return (T) elementData[index];

    }

    /**
     * @Desc:  [判断是否为空]
     * @param :  void
     * @return : boolean
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 15:35
     * @version : v1.0
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @Desc:  [线性表置空]
     * @param :  void
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 15:36
     * @version : v1.0
     */
    public void clear() {
        Arrays.fill(elementData, null);
        size = 0;
    }
    
    /**
     * @Desc:  [获取指定位置前一个元素]
     * @param :  int
     * @return : T
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 15:36
     * @version : v1.0
     */
    public T priorElem(int index) {
        if (index > 0 && index < size + 1)
            return (T) elementData[index - 1];
        else {
            throw new IndexOutOfBoundsException("数组越界异常");
        }
    }

    /**
     * @Desc:  [移除指定位置元素]
     * @param :  int
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 15:37
     * @version : v1.0
     */
    public void delete(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("数组越界异常");
        } else {
            //把数组前移一位
            System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
            size--;
            //清空最后一个元素
            elementData[size] = null;
        }
    }

    /**
     * @Desc:  [获取指定位置下一个元素]
     * @param :  int
     * @return : T
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 15:37
     * @version : v1.0
     */
    public T nextElem(int index) {
        if (index == -1) {
            return (T) elementData[0];
        } else if (index < size - 1 && index > -1) {
            return (T) elementData[index + 1];
        } else {
            throw new IndexOutOfBoundsException("数组越界异常");
        }
    }

    /**
     * @Desc:  [保证元素长度大于默认值]
     * @param :  int
     * @return : void
     * @author :  ANGLE0
     * @createTime ：  2019/12/21 15:38
     * @version : v1.0
     */
    private void ensurelength(int newLength) {
        if (newLength > length) {
            length = newLength + 2;
            elementData = Arrays.copyOf(elementData, length);
        }
    }
}
