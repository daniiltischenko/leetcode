package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_1389 {
    public static void main(String[] args) {
        System.out.println(Arrays.equals(createTargetArray_01(new int[]{0,1,2,3,4}, new int[]{0,1,2,2,1}), new int[]{0,4,1,3,2}));
        System.out.println(Arrays.equals(createTargetArray_01(new int[]{1,2,3,4,0}, new int[]{0,1,2,3,0}), new int[]{0,1,2,3,4}));
        System.out.println(Arrays.equals(createTargetArray_01(new int[]{1}, new int[]{0}), new int[]{1}));

        System.out.println(Arrays.equals(createTargetArray_02(new int[]{0,1,2,3,4}, new int[]{0,1,2,2,1}), new int[]{0,4,1,3,2}));
        System.out.println(Arrays.equals(createTargetArray_02(new int[]{1,2,3,4,0}, new int[]{0,1,2,3,0}), new int[]{0,1,2,3,4}));
        System.out.println(Arrays.equals(createTargetArray_02(new int[]{1}, new int[]{0}), new int[]{1}));
    }

    //Runtime: 0 ms, faster than 100% of Java online submissions for Create Target Array in the Given Order.
    static int[] createTargetArray_01(int[] nums, int[] index) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        for (int i = 0; i < index.length; i++) {
            if (result[index[i]] != -1) {
                System.arraycopy(result, index[i], result, index[i] + 1, index.length - index[i] - 1);
            }

            result[index[i]] = nums[i];
        }

        return result;
    }

    //Runtime: 3 ms, faster than 14.17% of Java online submissions for Create Target Array in the Given Order.
    static int[] createTargetArray_02(int[] nums, int[] index) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            result.add(index[i], nums[i]);
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
