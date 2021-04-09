package com.w.practise.leetcode.practise;

import java.util.ArrayList;

/**
 * @ClassName SetZero
 * @Description [数组置零]
 * @Author ANGLE0
 * @Date 2020/5/19 21:10
 * @Version V1.0
 **/
public class SetZero {
    public void setZeroes(int[][] matrix) {
        int width = matrix.length;
        int height = matrix[0].length;

        class Node{
            private int i;
            private int j;

            public Node(int i, int j) {
                this.i = i;
                this.j = j;
            }
        }

        ArrayList list = new ArrayList();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (matrix[i][j] == 0){
                    list.add(new Node(i, j));
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            Node temp = (Node) list.get(i);
            rowZero(matrix, temp.i);
            column(matrix, temp.j);
        }

    }

    public void rowZero(int[][] nums, int row){
        for (int i = 0; i < nums[0].length; i++) {
            nums[row][i] = 0;
        }
    }

    public void column(int[][] nums, int col){
        for (int i = 0; i < nums.length; i++) {
            nums[i][col] = 0;
        }
    }
}
