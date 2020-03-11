package com.leetcode;

import java.util.Arrays;

public class LC_1365 {
    public static void main(String[] args) {
        System.out.println(Arrays.equals(smallerNumbersThanCurrent_01(new int[]{8,1,2,2,3}), new int[]{4,0,1,1,3}));
        System.out.println(Arrays.equals(smallerNumbersThanCurrent_01(new int[]{6,5,4,8}), new int[]{2,1,0,3}));
        System.out.println(Arrays.equals(smallerNumbersThanCurrent_01(new int[]{7,7,7,7}), new int[]{0,0,0,0}));

        System.out.println(Arrays.equals(smallerNumbersThanCurrent_02(new int[]{8,1,2,2,3}), new int[]{4,0,1,1,3}));
        System.out.println(Arrays.equals(smallerNumbersThanCurrent_02(new int[]{6,5,4,8}), new int[]{2,1,0,3}));
        System.out.println(Arrays.equals(smallerNumbersThanCurrent_02(new int[]{7,7,7,7}), new int[]{0,0,0,0}));
    }

    static int[] smallerNumbersThanCurrent_01(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);

        for (int i = 0; i < nums.length; i++) {
            int position = 0;
            for (int j = 0; j < copy.length; j++) {
                if (copy[j] == nums[i]) {
                    position = j;
                    break;
                }
            }
            nums[i] = position;
        }

        return nums;
    }

    static int[] smallerNumbersThanCurrent_02(int[] nums) {
        int[] numbers = new int[101];
        int previous = 0;
        for (int i = 0; i < nums.length; i++) {
            numbers[nums[i]]++;
        }

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            numbers[i] = previous;
            previous += number;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = numbers[nums[i]];
        }

        return nums;
    }
}
