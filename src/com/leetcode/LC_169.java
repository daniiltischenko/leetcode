package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC_169 {
    public static void main(String[] args) {
        System.out.println(majorityElement_01(new int[]{3,2,3}) == 3);
        System.out.println(majorityElement_01(new int[]{2,2,1,1,1,2,2}) == 2);
        System.out.println();
        System.out.println(majorityElement_02(new int[]{3,2,3}) == 3);
        System.out.println(majorityElement_02(new int[]{2,2,1,1,1,2,2}) == 2);
        System.out.println();
    }

    static int majorityElement_01(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer occurrence = map.getOrDefault(num, 0);
            if (++occurrence > nums.length / 2) {
                return num;
            }
            map.put(num, occurrence);
        }
        return -1;
    }

    static int majorityElement_02(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
