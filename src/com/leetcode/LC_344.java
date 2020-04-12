package com.leetcode;

import java.util.Arrays;

public class LC_344 {
    public static void main(String[] args) {
        System.out.println(Arrays.equals(reverseString_01(new char[]{'h','e','l','l','o'}), new char[]{'o','l','l','e','h'}));
        System.out.println(Arrays.equals(reverseString_01(new char[]{}), new char[]{}));
        System.out.println(Arrays.equals(reverseString_01(new char[]{'h'}), new char[]{'h'}));

        System.out.println(Arrays.equals(reverseString_02(new char[]{'h','e','l','l','o'}), new char[]{'o','l','l','e','h'}));
        System.out.println(Arrays.equals(reverseString_02(new char[]{}), new char[]{}));
        System.out.println(Arrays.equals(reverseString_02(new char[]{'h'}), new char[]{'h'}));

        System.out.println(Arrays.equals(reverseString_03(new char[]{'h','e','l','l','o'}), new char[]{'o','l','l','e','h'}));
        System.out.println(Arrays.equals(reverseString_03(new char[]{}), new char[]{}));
        System.out.println(Arrays.equals(reverseString_03(new char[]{'h'}), new char[]{'h'}));

        System.out.println(Arrays.equals(reverseString_04(new char[]{'h','e','l','l','o'}), new char[]{'o','l','l','e','h'}));
        System.out.println(Arrays.equals(reverseString_04(new char[]{}), new char[]{}));
        System.out.println(Arrays.equals(reverseString_04(new char[]{'h'}), new char[]{'h'}));
    }

    static char[] reverseString_01(char[] s) {
        for (int i = 0, j = s.length - 1; i < s.length/2; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        return s;
    }

    static char[] reverseString_02(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start< end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
        return s;
    }

    static char[] reverseString_03(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
        return s;
    }

    static char[] reverseString_04(char[] s) {
         return reverse(s, 0, s.length - 1);
    }

    static char[] reverse(char[] s, int start, int end) {
        if (start >= end) {
            return s;
        }

        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;

        return reverse(s, ++start, --end);
    }
}
