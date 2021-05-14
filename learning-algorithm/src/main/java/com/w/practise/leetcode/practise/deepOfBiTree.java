package com.w.practise.leetcode.practise;

/**
 * @ClassName deepOfBiTree
 * @Description [二叉树深度]
 * @Author ANGLE0
 * @Date 2020/5/5 16:37
 * @Version V1.0
 **/
public class deepOfBiTree {
    class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
    public int maxDepth(TreeNode root) {
        return deep(root, 1);
    }

    public int deep(TreeNode root, int deep){
        if (root == null) return deep;
        int ld = deep + deep(root.left, deep+1);
        int rd = deep + deep(root.right, deep+1);
        return Math.max(ld, rd);
    }
}

