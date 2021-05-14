package com.w.local.dataMining.di3;

/**
 * @ClassName TreeNode
 * @Description [节点定义]
 * @Author ANGLE0
 * @Date 2020/6/22 15:40
 * @Version V1.0
 **/
public class TreeNode {

    private int  Attrib_Col; //属性
    private int Value; //对应边值
    private TreeNode  Left_Node;//子树
    private TreeNode Right_Node;//同层其他节点
    private Boolean IsLeaf;//是否叶子节点
    private int ClassNo;//分类标号

    public TreeNode(int attrib_Col, int value) {
        Attrib_Col = attrib_Col;
        Value = value;
    }

    public TreeNode(int value) {
        Value = value;
    }

    public TreeNode(int attrib_Col, int value, TreeNode left_Node, TreeNode right_Node, Boolean isLeaf, int classNo) {
        Attrib_Col = attrib_Col;
        Value = value;
        Left_Node = left_Node;
        Right_Node = right_Node;
        IsLeaf = isLeaf;
        ClassNo = classNo;
    }

    public int getAttrib_Col() {
        return Attrib_Col;
    }

    public void setAttrib_Col(int attrib_Col) {
        Attrib_Col = attrib_Col;
    }

    public int getValue() {
        return Value;
    }

    public void setValue(int value) {
        Value = value;
    }

    public TreeNode getLeft_Node() {
        return Left_Node;
    }

    public void setLeft_Node(TreeNode left_Node) {
        Left_Node = left_Node;
    }

    public TreeNode getRight_Node() {
        return Right_Node;
    }

    public void setRight_Node(TreeNode right_Node) {
        Right_Node = right_Node;
    }

    public Boolean getLeaf() {
        return IsLeaf;
    }

    public void setLeaf(Boolean leaf) {
        IsLeaf = leaf;
    }

    public int getClassNo() {
        return ClassNo;
    }

    public void setClassNo(int classNo) {
        ClassNo = classNo;
    }
}
