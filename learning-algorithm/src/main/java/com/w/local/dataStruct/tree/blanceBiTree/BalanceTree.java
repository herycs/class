package com.w.local.dataStruct.tree.blanceBiTree;

/**
 * @ClassName BlanceTree
 * @Description [平衡树]
 * @Author ANGLE0
 * @Date 2020/5/19 12:02
 * @Version V1.0
 **/
public class BalanceTree {

    public int data;
    public int depth;
    public int balance;
    public BalanceTree parent;
    public BalanceTree left;
    public BalanceTree right;

    public BalanceTree(int data) {
        this.data = data;
        depth = 1;
        balance = 0;
        left = null;
        right = null;
    }

    public void insert(BalanceTree root, int data) {
        if (data < root.data) {
            if (root.left != null) {
                insert(root.left, data);
            } else {
                root.left = new BalanceTree(data);
                root.left.parent = root;
            }
        } else {
            if (root.right != null) {
                insert(root.right, data);
            } else {
                root.right = new BalanceTree(data);
                root.right.parent = root;
            }
        }

        // 从插入的过程回溯回来的时候，计算平衡因子
        root.balance = calcBalance(root);

        // 左子树高，应该右旋
        if (root.balance >= 2) {
            // 右孙高，先左旋
            if (root.left.balance == -1) {
                left_rotate(root.left);
            }
            right_rotate(root);
        }

        // 右子树高，左旋
        if (root.balance <= -2) {
            // 左孙高，先右旋
            if (root.right.balance == 1) {
                right_rotate(root.right);
            }
            left_rotate(root);
        }

        root.balance = calcBalance(root);
        root.depth = calcDepth(root);
    }

    // 右旋
    private void right_rotate(BalanceTree p) {
        // 一次旋转涉及到的结点包括祖父，父亲，右儿子
        BalanceTree pParent = p.parent;
        BalanceTree pLeftSon = p.left;
        BalanceTree pRightGrandSon = pLeftSon.right;

        // 左子变父
        pLeftSon.parent = pParent;
        if (pParent != null) {
            if (p == pParent.left) {
                pParent.left = pLeftSon;
            } else if (p == pParent.right) {
                pParent.right = pLeftSon;
            }
        }

        pLeftSon.right = p;
        p.parent = pLeftSon;

        // 右孙变左孙
        p.left = pRightGrandSon;
        if (pRightGrandSon != null) {
            pRightGrandSon.parent = p;
        }

        p.depth = calcDepth(p);
        p.balance = calcBalance(p);

        pLeftSon.depth = calcDepth(pLeftSon);
        pLeftSon.balance = calcBalance(pLeftSon);
    }

    private void left_rotate(BalanceTree p) {
        // 一次选择涉及到的结点包括祖父，父亲，左儿子
        BalanceTree pParent = p.parent;
        BalanceTree pRightSon = p.right;
        BalanceTree pLeftGrandSon = pRightSon.left;

        // 右子变父
        pRightSon.parent = pParent;
        if (pParent != null) {
            if (p == pParent.right) {
                pParent.right = pRightSon;
            } else if (p == pParent.left) {
                pParent.left = pRightSon;
            }
        }

        pRightSon.left = p;
        p.parent = pRightSon;

        // 左孙变右孙
        p.right = pLeftGrandSon;
        if (pLeftGrandSon != null) {
            pLeftGrandSon.parent = p;
        }

        p.depth = calcDepth(p);
        p.balance = calcBalance(p);

        pRightSon.depth = calcDepth(pRightSon);
        pRightSon.balance = calcBalance(pRightSon);
    }

    public int calcBalance(BalanceTree p) {
        int left_depth;
        int right_depth;

        if (p.left != null) {
            left_depth = p.left.depth;
        } else {
            left_depth = 0;
        }

        if (p.right != null) {
            right_depth = p.right.depth;
        } else {
            right_depth = 0;
        }

        return left_depth - right_depth;
    }

    public int calcDepth(BalanceTree p) {
        int depth = 0;
        if (p.left != null) {
            depth = p.left.depth;
        }

        if (p.right != null && depth < p.right.depth) {
            depth = p.right.depth;
        }

        depth++;
        return depth;
    }
}