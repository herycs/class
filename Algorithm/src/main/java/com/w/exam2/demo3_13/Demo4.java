package com.w.exam2.demo3_13;

/**
 * @ClassName Demo4
 * @Description [线程分配处理任务，求系统完成任务时间]
 * @Author ANGLE0
 * @Date 2021/3/13 20:32
 * @Version V1.0
 **/
public class Demo4 {
    public int minimumProcessTime (int[] jobs, int k) {
        // write code here
        if (jobs == null) return 0;

        if (jobs.length == k) return getMaxValue(jobs);

        int finishedTime = 0;
        int start = 0;
        int end = k - 1;
        while (start < jobs.length - 1 || end < jobs.length - 1) {
            int min = 0;
        }
        return 11;
    }

    public int getMaxValue(int[] array) {
        int maxVal = 0;
        for (int i = 0; i < array.length; i++) {
            maxVal = Math.max(array[i], maxVal);
        }
        return maxVal;
    }
}
