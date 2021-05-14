package com.w.practise.forOffer;

/**
 * @ClassName Main55_1
 * @Description [二叉树深度]
 * @Author ANGLE0
 * @Date 2020/7/28 10:11
 * @Version V1.0
 **/
public class Main55_1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }
}
