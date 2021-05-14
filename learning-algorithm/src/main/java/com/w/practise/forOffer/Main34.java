package com.w.practise.forOffer;

import java.util.*;

/**
 * @ClassName Main34
 * @Description [二叉树和为某一值的路径]
 * @Author ANGLE0
 * @Date 2020/7/28 17:12
 * @Version V1.0
 **/
public class Main34 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> res = null;
    public LinkedList<Integer> temp = null;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        res = new LinkedList<>();
        temp = new LinkedList<>();

        if (root == null) return res;
        process(root, sum);
        return res;
    }

    public void process(TreeNode root, int sum) {
        if (root == null) return;

        temp.add(root.val);
        sum -= root.val;

        if (root.left == null && root.right == null && sum == 0)
            res.add(new LinkedList<>(temp));
        if (root.left != null) process(root.left, sum);
        if (root.right != null ) process(root.right, sum);
        temp.removeLast();
        return;
    }
}
