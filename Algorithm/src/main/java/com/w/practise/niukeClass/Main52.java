package com.w.practise.niukeClass;

/**
 * @ClassName Main52
 * @Description [二叉树最大路径和]
 * @Author ANGLE0
 * @Date 2020/7/28 8:35
 * @Version V1.0
 **/
public class Main52 {

    /**
     * Title： [二叉树最大路和]
     *
     * DESC: [ 递归 ]
     *      {
     *          res 与 root 无关
     *              max L max | R max
     *          res 与 root 有关
     *              root 本身
     *              root + L head max
     *              root + R head max
     *              root + L head max + R head max
     *      }
     *
     * Time: O(  )
     * Space: O(  )
     *
     */

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    static class Info{
        public int maxPathSum;
        public int fromHeadPathSum;
        public Info(int p, int f){
            this.maxPathSum = p;
            this.fromHeadPathSum = f;
        }
    }

    public static Info process(TreeNode root){
        if (root == null) return null;

        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);

        int maxPathSum = Integer.MIN_VALUE;
        int fromHeadPathSum = Integer.MIN_VALUE;

        int p1, p2, p3, p4, p5, p6;
        p1 = p2 = p3 = p4 = p5 = p6 = Integer.MIN_VALUE;
        if (leftInfo != null) p1 = leftInfo.maxPathSum;
        if (rightInfo != null) p2 = leftInfo.maxPathSum;
        p3 = root.val;
        if (leftInfo != null) p4 = root.val + leftInfo.maxPathSum;
        if (rightInfo != null) p5 = root.val + rightInfo.maxPathSum;
        p6 = root.val + leftInfo.maxPathSum + leftInfo.maxPathSum;

        maxPathSum = Math.max(Math.max(p1, p2), Math.max(Math.max(p3, p4), Math.max(p5, p6)));
        fromHeadPathSum = Math.max(p3, Math.max(p4, p5));
        return new Info(maxPathSum, fromHeadPathSum);
    }
}
