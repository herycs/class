package com.w.exam2.demo3_13;

/**
 * @ClassName Demo2
 * @Description [删除最短子数组，使得数组剩余部分全是非递增的]
 * @Author ANGLE0
 * @Date 2021/3/13 19:49
 * @Version V1.0
 **/
public class Demo2 {
    public int findLengthOfShortestSubarray (int[] array) {
        // write code here
        if (array == null || array.length <= 1) return 0;

        //  以每一个值开始，获取非递增的数字个数
        int minLenOfSubArray = getUpDataNum(array, 0, array.length);

        if (minLenOfSubArray == array.length - 1) return minLenOfSubArray;

        for (int i = 0; i < array.length; i++) {

            int tempLen = getUpDataNum(array, i, array.length);

            if (tempLen == array.length - 1) return tempLen;
//            minLenOfSubArray = Math.min(minLenOfSubArray, tempLen);
            return tempLen;
        }
        return minLenOfSubArray;
    }

    public int getUpDataNum(int[] array, int start, int end) {
        int tempLen = 0;
        int currIndex = 0;
        int nextIndex = 0;
        for (int j = start; j < end - 1; j++) {
            currIndex = j;
            nextIndex = currIndex + 1;
            if (array[currIndex] <= array[nextIndex]) {
                tempLen += 1;
            }
        }
        return tempLen;
    }

    public static void main(String[] args) {
//        int[] testData = new int[]{1,2,3,4,5}; // 4
//        int[] testData = new int[]{3,2,1,1}; // 0
//        int[] testData = new int[]{2}; // 0
        int[] testData = new int[]{5,4,3,7,8,2,1}; // 2

//        System.out.println(findLengthOfShortestSubarray(testData));
    }
}
