package com.w.practise.forOffer;

/**
 * @ClassName Main07
 * @Description [重建二叉树]
 * @Author ANGLE0
 * @Date 2020/7/28 11:56
 * @Version V1.0
 **/
public class Main07 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;
        return rebuild(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode rebuild(
            int[] preorder, int L1, int R1,
            int[] inorder, int L2, int R2
    ){
        if (L1 > R1) return null;
        // 建立根
        TreeNode root = new TreeNode(preorder[L1]);

        // 拆分左右
        if (L1 == R1)
            return root;
        int inRootIndex = L2;
        for (; inRootIndex <= R2; inRootIndex++) {
            if (inorder[inRootIndex] == preorder[L1]){
                break;
            }
        }

        int leftNum = inRootIndex - L2;

        int preLeftEnd = L1 + leftNum;
        // 重建 + 拼接
        root.left = rebuild(preorder, L1 +1, preLeftEnd, inorder, L2, inRootIndex - 1);
        root.right = rebuild(preorder, preLeftEnd + 1, R1, inorder, inRootIndex + 1, R2);

        //返回上一层
        return root;
    }
}
