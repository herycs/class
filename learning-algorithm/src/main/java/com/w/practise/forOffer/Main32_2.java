package com.w.practise.forOffer;

import java.util.*;

/**
 * @ClassName Main32_2
 * @Description [从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。]
 * @Author ANGLE0
 * @Date 2020/7/28 11:11
 * @Version V1.0
 **/
public class Main32_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        ArrayList res = new ArrayList<Integer>();

        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            ArrayList list = new ArrayList<Integer>();
            for (int i = queue.size(); i > 0; i--){
                TreeNode temp  = queue.poll();
                list.add(temp.val);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            if (list != null) res.add(list);
        }
        return res;
    }
}
