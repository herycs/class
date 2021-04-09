package com.w.practise.niukeClass;

/**
 * @ClassName Main31
 * @Description [二叉树权值最大和路径]
 * @Author ANGLE0
 * @Date 2020/7/27 8:35
 * @Version V1.0
 **/
public class Main31 {
    static class Info{

        int sum = 0;

        public Info(int sum) {
            this.sum = sum;
        }
    }

    static class Node{
        Node left;
        Node right;
        int val;
    }

    public static Info process(Node x){
        if (x == null){
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int leftVal = 0;
        int rightVal = 0;
        int currVal = x.val;
        if (leftInfo != null){
            leftVal = currVal + leftInfo.sum;
        }
        if (rightInfo != null){
            rightVal = currVal + rightInfo.sum;
        }
        if (leftInfo != null && rightInfo != null){
            return new Info(Math.max(leftVal, rightVal));
        }
        return new Info(leftInfo != null ? leftVal : rightVal);
    }

    public static void main(String[] args) {
        Node node = new Node();
        Info res = process(node);
    }
}
