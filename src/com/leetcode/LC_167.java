package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC_167 {
    public static void main(String[] args) {
        System.out.println(Arrays.equals(twoSum_01(new int[]{2, 7, 11, 15}, 9), new int[]{1, 2}));
        System.out.println(Arrays.equals(twoSum_01(new int[]{3, 3}, 6), new int[]{1, 2}));

        System.out.println(Arrays.equals(twoSum_02(new int[]{2, 7, 11, 15}, 9), new int[]{1, 2}));
        System.out.println(Arrays.equals(twoSum_02(new int[]{3, 3}, 6), new int[]{1, 2}));
    }

    static int[] twoSum_01(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            Integer remainderIndex = map.get(target - numbers[i]);
            if (remainderIndex != null) {
                return new int[]{++remainderIndex, ++i};
            }

            map.put(numbers[i], i);
        }

        throw new RuntimeException();
    }

    static int[] twoSum_02(int[] numbers, int target) {
        for (int start = 0, end = numbers.length - 1; start != end;) {
            int sum = numbers[start] + numbers[end];

            if (sum == target) {
                return new int[]{++start, ++end};
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }

        throw new RuntimeException();
    }
}
