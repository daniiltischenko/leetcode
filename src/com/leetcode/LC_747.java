package com.leetcode;

public class LC_747 {
    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{3, 6, 1, 0}) == 1);
        System.out.println(dominantIndex(new int[]{1, 2, 3, 4}) == -1);
        System.out.println(dominantIndex(new int[]{0,0,0,1}) == 3);
        System.out.println(dominantIndex(new int[]{0,0,3,2}) == -1);
    }

    static int dominantIndex(int[] nums) {
        int max = 0;
        int maxIndex = -1;
        int secondMax = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }

        return max >= secondMax * 2 ? maxIndex : -1;
    }
}
