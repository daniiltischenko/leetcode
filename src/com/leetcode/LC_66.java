package com.leetcode;

import java.util.Arrays;

public class LC_66 {
    public static void main(String[] args) {
        System.out.println(Arrays.equals(plusOne_01(new int[]{1,2,3}), new int[]{1,2,4}));
        System.out.println(Arrays.equals(plusOne_01(new int[]{4,3,2,1}), new int[]{4,3,2,2}));
        System.out.println(Arrays.equals(plusOne_01(new int[]{4,3,2,9}), new int[]{4,3,3,0}));
        System.out.println(Arrays.equals(plusOne_01(new int[]{4,9,9,9}), new int[]{5,0,0,0}));
        System.out.println(Arrays.equals(plusOne_01(new int[]{9,9,9,8}), new int[]{9,9,9,9}));
        System.out.println(Arrays.equals(plusOne_01(new int[]{9,9}), new int[]{1,0,0}));
        System.out.println(Arrays.equals(plusOne_01(new int[]{9}), new int[]{1,0}));
    }

    static int[] plusOne_01(int[] digits) {
        boolean flag = true;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (flag) {
                if (i == 0 && digits[i] == 9) {
                    int[] result = new int[digits.length + 1];
                    result[i] = 1;
                    return result;
                }

                digits[i] = ++digits[i] % 10;
                flag = digits[i] == 0;
            }
        }

        return digits;
    }
}
