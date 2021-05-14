package com.w.local.dataStruct.tree.bitree;

/**
 * @ClassName SeqBiTree
 * @Description [顺序二叉树定义]
 * @Author ANGLE0
 * @Date 2019/12/29 15:58
 * @Version V1.0
 **/
public class SeqBiTreeChar {

    private int MAX_SIZE = 50;

    private int DEFAULT = 20;

    private char[] BiTree;

    private int laxt_index;

    public SeqBiTreeChar() {
    }

    public void Create(char[] data){
        this.MAX_SIZE = data.length;
        this.BiTree = new char[this.MAX_SIZE + 1 ];
        this.laxt_index = 0;

        for (int i = 0; i < this.MAX_SIZE; i++) {
            this.BiTree[++this.laxt_index] = data[i];
        }
    }

    public void display(){
        System.out.print("[");
        if (this.laxt_index > 0){
            for (int i = 1; i <= this.laxt_index; i++) {
                System.out.print(" "+this.BiTree[i]);
            }
        }
        System.out.print("]");
    }
}
