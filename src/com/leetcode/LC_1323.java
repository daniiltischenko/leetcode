package com.leetcode;

import java.util.*;

public class LC_1323 {
    public static void main(String[] args) {
        System.out.println(maximum69Number_01(9669) == 9969);
        System.out.println(maximum69Number_01(9996) == 9999);
        System.out.println(maximum69Number_01(9999) == 9999);

        System.out.println(maximum69Number_02(9669) == 9969);
        System.out.println(maximum69Number_02(9996) == 9999);
        System.out.println(maximum69Number_02(9999) == 9999);

        System.out.println(maximum69Number_03(9669) == 9969);
        System.out.println(maximum69Number_03(9996) == 9999);
        System.out.println(maximum69Number_03(9999) == 9999);
        System.out.println(maximum69Number_03(669) == 969);
    }

    static int maximum69Number_01(int num) {
        return Integer.parseInt(String.valueOf(num).replaceFirst("6", "9"));
    }

    static int maximum69Number_02(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '6') {
                chars[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }

    static int maximum69Number_03(int num) {
        Stack<Integer> list = new Stack<>();
        do {
            list.add(num % 10);
            num = num / 10;
        } while (num != 0);

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == 6) {
                list.set(i, 9);
                break;
            }
        }
        int sum = 0;
        int size = list.size();

        while (size > 0) {
            sum += list.pop() * (int) Math.pow(10, --size);
        }
        return sum;
    }
}
