package com.w.practise.niukeClass;

/**
 * @ClassName Main42
 * @Description [完全二叉树节点数]
 * @Author ANGLE0
 * @Date 2020/7/27 17:11
 * @Version V1.0
 **/
public class Main42 {

    /**
     * Time: O( h*log(n) )
     */

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    //  当前层开始的完全二叉树最大深度
    public static int getDeep(TreeNode root, int level){
        while (root != null){
            root = root.left;
            level++;
        }
        return level - 1;
    }

    public static int bs(TreeNode node, int level, int deep) {
        if (level == deep){
            return 1;
        }
        if (deep == getDeep(node.left, level + 1)){
            return 1 << (deep - level) + bs(node.right, level + 1, deep);
        } else {
            return 1 << (deep - level -1) + bs(node.left, level + 1, deep);
        }
    }

}
