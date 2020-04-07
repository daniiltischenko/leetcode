package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC_202 {
    public static void main(String[] args) {
        System.out.println(isHappy_01(19) == true);
        System.out.println(isHappy_01(2) == false);
        System.out.println(isHappy_01(7) == true);
        System.out.println(isHappy_01(3) == false);

        System.out.println(isHappy_02(19) == true);
        System.out.println(isHappy_02(2) == false);
        System.out.println(isHappy_02(7) == true);
        System.out.println(isHappy_02(3) == false);
    }

    static boolean isHappy_01(int n) {
        return isHappy_01(n, new HashSet<>());
    }

    static boolean isHappy_01(int n, Set<Integer> nums) {
        if (n == 1) {
            return true;
        }

        if (!nums.add(n)) {
            return false;
        }

        int sum = 0;
        for (char aChar : String.valueOf(n).toCharArray()) {
            sum += Character.getNumericValue(aChar) * Character.getNumericValue(aChar);
        }
        return isHappy_01(sum, nums);
    }

    static boolean isHappy_02(int n) {
        return isHappy_02(n, new HashSet<>());
    }

    static boolean isHappy_02(int n, Set<Integer> nums) {
        if (n == 1) {
            return true;
        }

        if (!nums.add(n)) {
            return false;
        }

        int sum = 0;
        int remain;
        while (n > 0) {
            remain = n % 10;
            sum += remain * remain;
            n /= 10;
        }

        return isHappy_02(sum, nums);
    }
}
