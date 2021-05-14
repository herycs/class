package com.w.local.dataStruct.tree.bitree;

/**
 * @ClassName LinkedBiTree
 * @Description [链式存储二叉树定义]
 * @Author ANGLE0
 * @Date 2019/12/29 16:19
 * @Version V1.0
 **/
public class LinkedBiTree<T> {

    /**
     * DES：
     *     [最大可存结点数量]
     */
    private int MAX_SIZE = 50;
    /**
     * DES：
     *     [默认最大可存结点数量]
     */
    private int DEFAULT_SIZE = 20;
    /**
     * DES：
     *     [根节点]
     */
    private LinkBiNode<T> root;
    /**
     * DES：
     *     [树高度]
     */
    private int height;

}
