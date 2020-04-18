package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_448 {
    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers_01(new int[]{4, 3, 2, 7, 8, 2, 3, 1}).equals(Arrays.asList(5,6)));
    }

    static List<Integer> findDisappearedNumbers_01(int[] nums) {
        int[] result = new int[nums.length];

        for (int num : nums) {
            result[num - 1] = num;
        }

        List<Integer> nulls = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) {
                nulls.add(i + 1);
            }
        }

        return nulls;
    }
}
