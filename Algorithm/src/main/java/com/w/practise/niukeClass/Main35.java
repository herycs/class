package com.w.practise.niukeClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName Main35
 * @Description [最大搜索二叉树子节点]
 * @Author ANGLE0
 * @Date 2020/7/27 8:16
 * @Version V1.0
 **/
public class Main35 {

    // 搜索树成立，1.左子树是二叉搜索树，2.右子树是搜索二叉树，3，左子树最大值小于根节点值，4.右子树最小值大于根节点值

    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    static class Info{
        public int maxBSTSize = 0;
        public boolean isAllBST = false;
        public int max = 0;
        public int min = 0;

        public Info(int maxBSTSize, boolean isAllBST, int max, int min) {
            this.maxBSTSize = maxBSTSize;
            this.isAllBST = isAllBST;
            this.max = max;
            this.min = min;
        }
    }

    public static Info getMaxSubInfo(Node root){
        if (root == null) return null;

        Info leftInfo = getMaxSubInfo(root.left);
        Info rightInfo = getMaxSubInfo(root.right);

        int maxBSTSize = 0;
        boolean isAllBST = false;

        //maxBSTSize
        // 当前节点无关，只与左子树有关
        int p1 = Integer.MIN_VALUE;
        if (leftInfo != null){
            p1 = leftInfo.maxBSTSize;
        }
        // 当前节点无关，只与右子树有关
        int p2 = Integer.MIN_VALUE;
        if (rightInfo != null){
            p2 = rightInfo.maxBSTSize;
        }
        // 当前节点有关
        int p3 = Integer.MIN_VALUE;
        if ((leftInfo == null || (leftInfo.isAllBST && leftInfo.max < root.val))
                        && (rightInfo == null || (rightInfo.isAllBST && rightInfo.min < root.val))){
            p3 = 1 + (leftInfo != null ? leftInfo.maxBSTSize : 0) + (rightInfo != null ? rightInfo.maxBSTSize : 0);
            isAllBST = true;
        }
        maxBSTSize = Math.max(p1, Math.max(p2, p3));
        //当前子树的全局最大值，和全局最小值
        int min = root.val;
        int max = root.val;
        if (leftInfo != null){
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null){
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }
        return new Info(maxBSTSize, isAllBST, max, min);
    }

    public static Node createTree(BufferedReader br){
        try{
            //输入是以先序遍历的顺序输入的，所以这里要按先序来接受
            String[] arr = br.readLine().trim().split(" ");
            int data = Integer.parseInt(arr[0]);
            int left = Integer.parseInt(arr[1]);
            int right = Integer.parseInt(arr[2]);
            Node root = new Node(data);
            if(left != 0){
                root.left = createTree(br);
            }
            if(right != 0){
                root.right = createTree(br);
            }
            return root;
        }catch(IOException e){
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        Node root = createTree(reader);
        System.out.println(getMaxSubInfo(root).maxBSTSize);
    }
}
