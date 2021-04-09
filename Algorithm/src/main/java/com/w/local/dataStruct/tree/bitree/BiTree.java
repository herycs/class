package com.w.local.dataStruct.tree.bitree;

/**
 * @ClassName BiTree
 * @Description [二叉树接口]
 * @Author ANGLE0
 * @Date 2019/12/29 15:42
 * @Version V1.0
 **/
public interface BiTree <T>{

    /**
     * DES：
     *     [初始化]
     *
     */
    void Initable();

    /**
     * DES：
     *     [创建空二叉树]
     *
     */
    void Create();

    /**
     * DES：
     *     [销毁二叉树]
     *
     */
    void Destory();

    /**
     * DES：
     *     [二叉树是否为空]
     *
     */
    boolean IsEmpty();

    /**
     * DES：
     *     [获取双亲]
     *
     */
    T getParent();

    /**
     * DES：
     *     [获取左孩子]
     *
     */
    T getLChild();

    /**
     * DES：
     *     [获取右孩子]
     *
     */
    T getRChild();

    /**
     * DES：
     *     [先序遍历]
     *
     */
    void PreOrder();

    /**
     * DES：
     *     [中序遍历]
     *
     */
    void InOrder();

    /**
     * DES：
     *     [后序遍历]
     *
     */
    void PostOrder();

    /**
     * DES：
     *     [层次遍历]
     *
     */
    void LevelOrder();
}
