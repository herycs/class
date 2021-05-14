package com.w.local.dataMining.apriori;

/**
 * @ClassName DataModel
 * @Description [数据模型]
 * @Author ANGLE0
 * @Date 2020/4/29 11:30
 * @Version V1.0
 **/
public class DataModel <K,V> implements DataRules{

    private K id;
    private V value;

    public K getId() {
        return id;
    }

    public void setId(K id) {
        this.id = id;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
