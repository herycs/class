package com.w.local.dataStruct.tree.bitree;

/**
 * @ClassName LinkBiNode
 * @Description [链式存储二叉结点定义]
 * @Author ANGLE0
 * @Date 2019/12/29 16:16
 * @Version V1.0
 **/
public class LinkBiNode<T> {

    private T data;

    private LinkBiNode LChild;

    private LinkBiNode RChild;

    /**
     * DES：
     *     [无参初始化]
     */
    public LinkBiNode() {
    }

    /**
     * DES：
     *     [带数据初始化]
     */
    public LinkBiNode(T data) {
        this.data = data;
    }

    /**
     * DES：
     *     [带数据及左右结点初始化]
     */
    public LinkBiNode(T data, LinkBiNode LChild, LinkBiNode RChild) {
        this.data = data;
        this.LChild = LChild;
        this.RChild = RChild;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkBiNode getLChild() {
        return LChild;
    }

    public void setLChild(LinkBiNode LChild) {
        this.LChild = LChild;
    }

    public LinkBiNode getRChild() {
        return RChild;
    }

    public void setRChild(LinkBiNode RChild) {
        this.RChild = RChild;
    }
}
