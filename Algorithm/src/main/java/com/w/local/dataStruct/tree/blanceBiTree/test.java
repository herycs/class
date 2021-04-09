package com.w.local.dataStruct.tree.blanceBiTree;

/**
 * @ClassName com.w.test
 * @Description [测试]
 * @Author ANGLE0
 * @Date 2020/5/19 12:02
 * @Version V1.0
 **/
public class test {
    public static void main(String[] args) {
        BalanceTree tree = new BalanceTree(1);

        int[] nums = new int[]{1,2,3,4,5,6};
        for (int i = 0; i < nums.length; i++) {
            tree.insert(tree, nums[i]);
        }

        
    }
}
