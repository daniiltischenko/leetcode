package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC_283 {
    public static void main(String[] args) {
        System.out.println(Arrays.equals(moveZeroes_01(new int[]{0,1,0,3,12}), new int[]{1,3,12,0,0}));
        System.out.println(Arrays.equals(moveZeroes_02(new int[]{0,1,0,3,12}), new int[]{1,3,12,0,0}));
        System.out.println(Arrays.equals(moveZeroes_03(new int[]{0,1,0,3,12}), new int[]{1,3,12,0,0}));
        System.out.println(Arrays.equals(moveZeroes_04(new int[]{0,1,0,3,12}), new int[]{1,3,12,0,0}));
    }

    static int[] moveZeroes_01(int[] nums) {
        boolean stop = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        if (j == nums.length - 1) stop = true;
                        break;
                    }
                }
                if (stop) {
                    break;
                }
            }
        }

        return nums;
    }

    static int[] moveZeroes_02(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(j, nums[i]);
                j++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < map.size()) {
                nums[i] = map.get(i);
            } else {
                nums[i] = 0;
            }
        }

        return nums;
    }

    static int[] moveZeroes_03(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }

        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;
        }

        return nums;
    }

    static int[] moveZeroes_04(int[] nums) {
        for (int lastNonZeroFoundAt = 0, i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = nums[i];
                nums[i] = temp;
                lastNonZeroFoundAt++;
            }
        }

        return nums;
    }
}
