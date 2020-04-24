package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC_217 {
    public static void main(String[] args) {
        System.out.println(containsDuplicate_01(new int[]{1, 2, 3, 1}) == true);
        System.out.println(containsDuplicate_01(new int[]{1, 2, 3, 4}) == false);
        System.out.println(containsDuplicate_01(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}) == true);

        System.out.println(containsDuplicate_02(new int[]{1, 2, 3, 1}) == true);
        System.out.println(containsDuplicate_02(new int[]{1, 2, 3, 4}) == false);
        System.out.println(containsDuplicate_02(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}) == true);
    }

    //Runtime: 3 ms, faster than 99.73% of Java online submissions for Contains Duplicate.
    static boolean containsDuplicate_01(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    //Runtime: 4 ms, faster than 81.02% of Java online submissions for Contains Duplicate.
    static boolean containsDuplicate_02(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}