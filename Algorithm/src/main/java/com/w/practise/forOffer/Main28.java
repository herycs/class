package com.w.practise.forOffer;

/**
 * @ClassName Main28
 * @Description [对称二叉树]
 * @Author ANGLE0
 * @Date 2020/7/28 11:42
 * @Version V1.0
 **/
public class Main28 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return root != null ? process(root.left, root.right) : false;
    }

    public boolean process(TreeNode L, TreeNode R){
        if (L == null && R == null) return true;

        if (L == null || R == null || L.val != R.val) return false;

        return process(L.left, R.right) && process(L.right, R.left);
    }
}
