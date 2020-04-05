package com.leetcode;

public class LC_724 {
    public static void main(String[] args) {
        System.out.println(pivotIndex_01(new int[]{1, 7, 3, 6, 5, 6}) == 3);
        System.out.println(pivotIndex_01(new int[]{1, 2, 3}) == -1);

        System.out.println(pivotIndex_02(new int[]{1, 7, 3, 6, 5, 6}) == 3);
        System.out.println(pivotIndex_02(new int[]{1, 2, 3}) == -1);
    }

    static int pivotIndex_01(int[] nums) {
        int length = nums.length;
        int[] leftSums = new int[length];
        int[] rightSums = new int[length];

        for (int i = 1, j = length - 2; i < length; i++, j--) {
            leftSums[i] = nums[i-1] + leftSums[i-1];
            rightSums[j] = nums[j+1] + rightSums[j+1];
        }

        for (int i = 0; i < length; i++) {
            if (leftSums[i] == rightSums[i]) {
                return i;
            }
        }

        return -1;
    }

    static int pivotIndex_02(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - nums[i] - leftSum) {
                return i;
            }
            leftSum +=nums[i];
        }

        return -1;
    }
}
