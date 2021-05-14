package com.w.practise.niukeClass;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Main12
 * @Description [容器装水]
 * @Author ANGLE0
 * @Date 2020/7/25 11:45
 * @Version V1.0
 **/
public class Main12 {

    // 一位数组，装水
    public static int getWater(int[] nums){

        if (nums == null || nums.length < 0) return 0;

        int left = 1;
        int right = nums.length - 2;
        int leftMax = nums[0];
        int rightMax = nums[nums.length - 1];
        int res = 0;

        while (left <= right){
            if (leftMax <= rightMax){
                res += Math.max(0, leftMax - nums[left]);
                leftMax = Math.max(leftMax, nums[left++]);
            } else {
                res += Math.max(0, rightMax - nums[right]);
                rightMax = Math.max(rightMax, nums[right--]);
            }
        }
        return res;
    }

    // 二维数组，装水
    static class Node{
        public int row;
        public int col;
        public int water;

        public Node(int row, int col, int water) {
            this.row = row;
            this.col = col;
            this.water = water;
        }
    }

    static class NodeCompeter implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o1.water - o2.water;
        }
    }
    // 流程：进堆结算水量，并将其上下左右未进堆的值进堆
    public static int getWater2(int[][] nums){

        if (nums == null || nums.length == 0 || nums[0] == null || nums[0].length == 0) return 0;

        PriorityQueue heap = new PriorityQueue(new NodeCompeter());

        int rows = nums.length;
        int cols = nums[0].length;

        boolean[][] isEnter = new boolean[rows][cols];

        //边框进堆
        for (int i = 0; i < cols; i++) {
            isEnter[0][i] = true;
            heap.add(new Node(0, i, nums[0][i]));
        }
        for (int i = 0; i < rows; i++) {
            isEnter[i][cols - 1] = true;
            heap.add(new Node(i, cols - 1, nums[i][cols - 1]));
        }
        for (int i = cols - 1; i > 0; i++) {
            isEnter[rows - 1][i] = true;
            heap.add(new Node(rows - 1, i, nums[rows - 1][i]));
        }
        for (int i = rows - 1; i > 0; i++) {
            isEnter[i][0] = true;
            heap.add(new Node(i, 0, nums[i][0]));
        }

        int max = 0;
        int water = 0;
        while (!heap.isEmpty()){
            Node temp = (Node) heap.poll();
            max = Math.max(max, temp.water);
            int row = temp.row;
            int col = temp.col;

            if (row > 0 && !isEnter[row - 1][col]){
                water += Math.max(0, max - nums[row - 1][col]);
                isEnter[row - 1][col] = true;
                heap.add(new Node(row - 1, col, nums[row - 1][col]));
            }
            if (col < cols - 1 && !isEnter[row][col + 1]){
                water += Math.max(0, max - nums[row][col + 1]);
                isEnter[row][col + 1] = true;
                heap.add(new Node(row, col + 1, nums[row][col + 1]));
            }
            if (row < rows - 1 && !isEnter[row + 1][col]){
                water += Math.max(0, max - nums[row + 1][col]);
                isEnter[row + 1][col] = true;
                heap.add(new Node(row + 1, col, nums[row + 1][col]));
            }
            if (col > 0 && !isEnter[row][col - 1]){
                water += Math.max(0, max - nums[row][col - 1]);
                isEnter[row][col - 1] = true;
                heap.add(new Node(row, col - 1, nums[row][col - 1]));
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1,1,1,1,1};
        System.out.println(getWater(nums));
    }
}
