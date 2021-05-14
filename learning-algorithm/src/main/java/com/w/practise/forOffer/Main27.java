package com.w.practise.forOffer;

/**
 * @ClassName Main27
 * @Description [二叉树的镜像]
 * @Author ANGLE0
 * @Date 2020/7/28 10:01
 * @Version V1.0
 **/
public class Main27 {
    /**
     * Title： [请完成一个函数，输入一个二叉树，该函数输出它的镜像。]
     * <p>
     * DESC: [ 递归 ]
     * {
     * <p>
     * }
     * <p>
     * Time: O(  )
     * Space: O(  )
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);

        return root;
    }
}
