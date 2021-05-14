package com.w.practise.forOffer;

/**
 * @ClassName Main55_2
 * @Description [平衡二叉树]
 * @Author ANGLE0
 * @Date 2020/7/28 11:23
 * @Version V1.0
 **/
public class Main55_2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return process(root) != -1;
    }

    public int process(TreeNode root){
        if (root == null) return 0;

        int left = process(root.left);
        if (left == -1) return -1;
        int right = process(root.right);
        if (right == -1) return -1;

        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }
}
