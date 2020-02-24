package com.leetcode;

import java.util.Arrays;

public class LC_1295 {
    public static void main(String[] args) {
        System.out.println(findNumbers_01(new int[]{12,345,2,6,7896}) == 2);
        System.out.println(findNumbers_01(new int[]{555,901,482,1771}) == 1);

        System.out.println(findNumbers_02(new int[]{12,345,2,6,7896}) == 2);
        System.out.println(findNumbers_02(new int[]{555,901,482,1771}) == 1);

        System.out.println(findNumbers_03(new int[]{12,345,2,6,7896}) == 2);
        System.out.println(findNumbers_03(new int[]{555,901,482,1771}) == 1);

    }

    static int findNumbers_01(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            if (hasEvenNumOfDigits(num)) sum++;
        }
        return sum;
    }

    static boolean hasEvenNumOfDigits(int n) {
        int num = 0;
        do {
            n /= 10;
            num++;
        } while (n != 0);

        return num % 2 == 0;
    }

    static int findNumbers_02(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += ((int)Math.log10(num) + 1) % 2 == 0 ? 1 : 0;
        }
        return sum;
    }

    static int findNumbers_03(int[] nums) {
        return (int) Arrays.stream(nums)
                .filter(num -> ((int)Math.log10(num) + 1) % 2 == 0)
                .count();
    }
}
