package com.w.practise.forOffer;

/**
 * @ClassName Main54
 * @Description [二叉树的第k个结点]
 * @Author ANGLE0
 * @Date 2020/7/28 10:49
 * @Version V1.0
 **/
public class Main54 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int res = 0;
    private int k = 0;

    public int kthLargest(TreeNode root, int k) {
        if (root == null) return -1;
        this.k = k;
        process(root);
        return res;
    }

    public void process(TreeNode root){
        if (root == null || k == 0) return;
        process(root.right);
        if (--k == 0) res = root.val;
        process(root.left);
    }
}
