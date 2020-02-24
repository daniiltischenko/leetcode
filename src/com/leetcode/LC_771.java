package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC_771 {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones_01("aA", "aAAbbbb") == 3);
        System.out.println(numJewelsInStones_01("z", "ZZ") == 0);

        System.out.println(numJewelsInStones_02("aA", "aAAbbbb") == 3);
        System.out.println(numJewelsInStones_02("z", "ZZ") == 0);

        System.out.println(numJewelsInStones_03("aA", "aAAbbbb") == 3);
        System.out.println(numJewelsInStones_03("z", "ZZ") == 0);

        System.out.println(numJewelsInStones_04("aA", "aAAbbbb") == 3);
        System.out.println(numJewelsInStones_04("z", "ZZ") == 0);
    }

    static int numJewelsInStones_01(String J, String S) {
        Set<Character> jewels = new HashSet<>();
        for (char c : J.toCharArray()) {
            jewels.add(c);
        }

        int sum = 0;
        for (char c : S.toCharArray()) {
            if (jewels.contains(c)) {
                sum++;
            }
        }

        return sum;
    }

    static int numJewelsInStones_02(String J, String S) {
        int sum = 0;
        for (char stone : S.toCharArray()) {
            for (char jewel : J.toCharArray()) {
                if (stone == jewel) {
                    sum++;
                }
            }
        }
        return sum;
    }

    static int numJewelsInStones_03(String J, String S) {
        int sum = 0;

        for (int i = 0; i < J.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (S.charAt(j) == J.charAt(i)) {
                    sum++;
                }
            }
        }

        return sum;
    }

    static int numJewelsInStones_04(String J, String S) {
        int sum = 0;
        for (char jewel : J.toCharArray()) {
            sum += S.chars().filter(ch -> ch == jewel).count();
        }
        return sum;
    }

}
