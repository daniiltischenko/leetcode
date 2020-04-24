package com.leetcode;

public class LC_171 {
    public static void main(String[] args) {
        System.out.println(titleToNumber("A") == 1);
        System.out.println(titleToNumber("AA") == 27);
        System.out.println(titleToNumber("AB") == 28);
        System.out.println(titleToNumber("ZY") == 701);
    }

    static int titleToNumber(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sum = sum * 26 + (chars[i] - 'A' + 1);
        }
        return sum;
    }
}
