package com.w.practise.book;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName Main
 * @Description [book]
 * @Author ANGLE0
 * @Date 2020/9/11 10:36
 * @Version V1.0
 **/
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        for (int i = 0; i < nums.length; i++) {
            perm(nums, i);
        }
        testCollectionsPrem();
    }

    // 测试集合的全排列
    private static void testCollectionsPrem() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        traverse(list, new ArrayList<>());
    }

    // {a, b, c} -> {} => {b, c} -> {a}
    public static void traverse(ArrayList<Integer> listNums, ArrayList<Integer> auxList) {
        if (listNums.size() == 0) {
            System.out.println(Arrays.toString(auxList.toArray()));
        } else {
            for (int i = 0; i < listNums.size(); i++) {
                auxList.add(listNums.remove(i)); // item from listNums to auxList
                traverse(listNums, auxList);
                listNums.add(i, auxList.remove(auxList.size() - 1)); // item from auxList to listNums
            }
        }
    }

    // resort nums to get different sum
    public static void perm(int[] nums, int index) {
        if (index == nums.length - 1) {
            System.out.println(getValueOfNums(nums));
        } else {
//            System.out.println(index + "-" + (index + 1));
            for (int i = index + 1; i < nums.length; i++) {
                swap(nums, index, i);
                perm(nums, index + 1);
                swap(nums, index, i);
            }
        }
    }
    // exchange Value of indexI and indexJ
    public static void swap(int[] nums, int i, int j) {
        if (nums == null || nums.length < 2 || i < 0 || i >= nums.length || j < 0 || j >= nums.length) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    // nums[] -> intSum
    public static int getValueOfNums(int[] nums) {
        if (nums == null || nums.length < 1) return -1;
        int res = 0;
        int multiple = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res += multiple * nums[i];
            multiple *= 10;
        }
        return res;
    }
}
