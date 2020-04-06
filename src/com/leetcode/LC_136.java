package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC_136 {
    public static void main(String[] args) {
        System.out.println(singleNumber_01(new int[]{2,2,1}) == 1);
        System.out.println(singleNumber_01(new int[]{4,1,2,1,2}) == 4);

        System.out.println(singleNumber_02(new int[]{2,2,1}) == 1);
        System.out.println(singleNumber_02(new int[]{4,1,2,1,2}) == 4);

        System.out.println(singleNumber_03(new int[]{2,2,1}) == 1);
        System.out.println(singleNumber_03(new int[]{4,1,2,1,2}) == 4);

        System.out.println(singleNumber_04(new int[]{2,2,1}) == 1);
        System.out.println(singleNumber_04(new int[]{4,1,2,1,2}) == 4);
    }

    static int singleNumber_01(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i+=2) {
            if (i == nums.length-1) {
                return nums[i];
            }

            if (nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        return -1;
    }

    static int singleNumber_02(int[] nums) {
        Map<Integer, Integer> numToFrequency = new HashMap<>();
        for (int num : nums) {
            numToFrequency.put(num, numToFrequency.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : numToFrequency.entrySet()) {
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    static int singleNumber_03(int[] nums) {
        Map<Integer, Integer> numToFrequency = new HashMap<>();
        for (int num : nums) {
            numToFrequency.put(num, numToFrequency.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (numToFrequency.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }

    /**
     * Concept
     *
     * If we take XOR of zero and some bit, it will return that bit
     * a ⊕ 0 = a
     * If we take XOR of two same bits, it will return 0
     * a ⊕ a = 0
     * a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
     * So we can XOR all bits together to find the unique number.
     * @param nums
     * @return
     */
    static int singleNumber_04(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}

