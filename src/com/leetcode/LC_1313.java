package com.leetcode;

import java.util.Arrays;

public class LC_1313 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decompressRLElist(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(decompressRLElist_02(new int[]{1,2,3,4})));
    }

    static int[] decompressRLElist(int[] nums) {
        int[][] arrays = new int[nums.length/2][];
        int length = 0;
        for (int i = 0, j = 0; i < nums.length; i = i + 2, j++) {
            int a = nums[i];
            int b = nums[i+1];;
            arrays[j] = createArr(b, a);
            length = length + a;
        }

        int[] result = new int[length];
        int k = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                result[k] = arrays[i][j];
                k++;
            }
        }

        return result;
    }

    static int[] createArr(int value, int frequency) {
        int[] arr = new int[frequency];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = value;
        }
        return arr;
    }

    static int[] decompressRLElist_02(int[] nums) {
        int targetLength = 0;
        for (int i = 0; i < nums.length; i = i +2) {
            targetLength = targetLength + nums[i];
        }
        int[] result = new int[targetLength];

        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            int freq = nums[i];
            int val = nums[i+1];
            end = end + freq;
            for (int j = start; j < end; j++) {
                result[j] = val;
                start++;
            }
        }

        return result;
    }
}
