package com.leetcode;

public class LC_1342 {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(14) == 6);
        System.out.println(numberOfSteps(8) == 4);
        System.out.println(numberOfSteps(123) == 12);
    }

    static int numberOfSteps (int num) {
        return rec(num, 0);
    }

    static int rec(int num, int count) {
        if (num == 0) {
            return count;
        } else if (isEven(num)) {
            return rec(num / 2, ++count);
        } else {
            return rec(num - 1, ++count);
        }
    }

    static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
