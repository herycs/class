package com.w.exam.demo28;

/**
 * @ClassName Main2
 * @Description [����]
 * @Author ANGLE0
 * @Date 2020/9/15 15:12
 * @Version V1.0
 **/
public class Main2 {
    /*
        int[] �ظ�ֵ
        ɾȥ�ظ�ֵ

        [ x x x x x x, xxxxxx]
        slow            fast

        slow ���µ�ǰӦ���λ��
        fast ���ڱ���


     */

    public static void main(String[] args) {
//        int[] nums = new int[]{1,1,2};
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(deleteSameNumber(nums));
    }
    // ɾ���ظ����ֵ�����
    public static int deleteSameNumber(int[] nums) {
        // ˼·�� ˫ָ��
        if (nums == null || nums.length < 1) return -1; // ����쳣

        int slow = 0; // ��ָ��
        int fast = 1; // ��ָ��
        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                fast++;
            } else {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
