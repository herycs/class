package com.w.practise.niukeClass;

/**
 * @ClassName Main51
 * @Description [二叉树最小高度]
 * @Author ANGLE0
 * @Date 2020/7/27 17:42
 * @Version V1.0
 **/
public class Main51 {
    /**
     * Title： [二叉树最小高度]
     *
     * DESC: [ 策略 ]
     *      {
     *          1.递归---空间复杂度高，O(n)
     *          2.摩尔斯遍历---面试
     *      }
     *
     */
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static int getMinHeight(TreeNode root) {
        if (root == null) return 0;
        return process(root);
    }

    public static int process(TreeNode root) {
        if (root.left == null && root.right == null) return 1;
        int lh = Integer.MIN_VALUE;
        if (root.left != null) {
            lh = process(root.left);
        }
        int rh = Integer.MIN_VALUE;
        if (root.right != null) {
            rh = process(root.right);
        }
        return 1 + Math.min(lh, rh);
    }
}
