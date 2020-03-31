package com.leetcode;

import java.util.Arrays;

public class LC_1299 {
    public static void main(String[] args) {
        System.out.println(Arrays.equals(replaceElements(new int[]{17,18,5,4,6,1}), new int[]{18,6,6,6,1,-1}));
    }

    static int[] replaceElements(int[] arr) {
        int[] result = new int[arr.length];

        for (int i = arr.length - 1, max = 0; i >= 0; i--) {
            result[i] = max;
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        result[result.length-1] = -1;

        return result;
    }
}
