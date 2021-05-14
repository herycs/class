package com.w.local.dataStruct.linearList;

/**
 * @ClassNameMyList
 * @Description
 * @Author ANGLE0
 * @Date 2019/12/21 14:44
 * @Version V1.0
 **/
public interface MyList {
    void clear();

    boolean isEmpty();

    int length();

    Object get(int i) throws Exception;

    void insert(int i, Object x) throws Exception;

    void remove(int i) throws Exception;

    int indexOf(Object x);

    void display();
}
