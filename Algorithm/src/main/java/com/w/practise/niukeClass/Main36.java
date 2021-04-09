package com.w.practise.niukeClass;

/**
 * @ClassName Main36
 * @Description [最大路径和]
 * @Author ANGLE0
 * @Date 2020/7/27 8:44
 * @Version V1.0
 **/
public class Main36 {

    /**
     * Title： [节点个数最大和]
     *
     * Time: O( n )
     *
     */

    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    static class Info{
        public int height;
        public int maxPathLen;
        public Info(int h, int len){
            this.height = h;
            this.maxPathLen = len;
        }
    }

    public static Info getMaxPathLen(Node root){
        if (root == null) return null;

        //左右
        Info leftInfo = getMaxPathLen(root.left);
        Info rightInfo = getMaxPathLen(root.right);
        //更新值
        int maxHeight = (leftInfo != null ? leftInfo.height : 0);
        maxHeight = Math.max(maxHeight, (rightInfo != null ? leftInfo.height : 0));
        int maxPathLen = 1 +  (leftInfo != null ? leftInfo.height : 0) + (rightInfo != null ? leftInfo.height : 0);
        if (leftInfo != null){
            maxPathLen = Math.max(maxPathLen, (leftInfo != null ? leftInfo.height : 0));
        }
        if (rightInfo != null){
            maxPathLen = Math.max(maxPathLen, (rightInfo != null ? rightInfo.height : 0));
        }
        //返回
        return new Info(maxHeight, maxPathLen);
    }


    // 最大子树和，节点值的和
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int max = Integer.MIN_VALUE;

    public int maxPathSum (TreeNode root) {
        // write code here
        getMaxVal(root);
        return max;
    }

    public int getMaxVal(TreeNode root){
        if (root == null) return 0;

        int left = Math.max(0, getMaxVal(root.left));
        int right = Math.max(0, getMaxVal(root.right));

        max = Math.max(max, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
