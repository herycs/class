package com.w.practise.forOffer;

import java.util.*;

/**
 * @ClassName Main32_3
 * @Description [二叉树打印，z 型路径]
 * @Author ANGLE0
 * @Date 2020/7/28 16:41
 * @Version V1.0
 **/
public class Main32_3 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List res = new ArrayList<ArrayList>();

        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = 0;
            LinkedList<Integer> list = new LinkedList();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode temp = queue.poll();

                if (res.size() % 2 == 0){
                    list.addLast(temp.val);
                } else {
                    list.addFirst(temp.val);
                }

                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            res.add(list);
            level++;
        }
        return res;
    }
}
