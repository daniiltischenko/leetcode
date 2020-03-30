package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC_1 {
    public static void main(String[] args) {
        System.out.println(Arrays.equals(twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1}));
        System.out.println(Arrays.equals(twoSum(new int[]{3, 3}, 6), new int[]{0, 1}));
    }

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer remainderIndex = map.get(target - nums[i]);
            if (remainderIndex != null) {
                return new int[]{remainderIndex, i};
            }

            map.put(nums[i], i);
        }

        throw new RuntimeException();
    }

}
