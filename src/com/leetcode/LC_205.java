package com.leetcode;

import java.util.*;

public class LC_205 {

    public static void main(String[] args) {
        System.out.println(isIsomorphic_01("egg", "add") == true);
        System.out.println(isIsomorphic_01("foo", "bar") == false);
        System.out.println(isIsomorphic_01("paper", "title") == true);
        System.out.println(isIsomorphic_01("ab", "aa") == false);
        System.out.println(isIsomorphic_01("aa", "ab") == false);
        System.out.println(isIsomorphic_01("aba", "baa") == false);

        System.out.println(isIsomorphic_02("egg", "add") == true);
        System.out.println(isIsomorphic_02("foo", "bar") == false);
        System.out.println(isIsomorphic_02("paper", "title") == true);
        System.out.println(isIsomorphic_02("ab", "aa") == false);
        System.out.println(isIsomorphic_02("aa", "ab") == false);
        System.out.println(isIsomorphic_02("aba", "baa") == false);
    }

    public static boolean isIsomorphic_01(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();

        int length = s.length();

        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();

        for (int i = 0; i < length; i++) {
            char curCharsS = charsS[i];
            char curCharsT = charsT[i];

            if (map.get(curCharsS) == null) {

                if (used.contains(curCharsT)) {
                    return false;
                }

                map.put(curCharsS, curCharsT);
                used.add(curCharsT);
            } else if (map.get(curCharsS) == curCharsT) {
                continue;
            } else if (map.get(curCharsS) != curCharsT) {
                return false;
            }
        }

        return true;

    }

    public static boolean isIsomorphic_02(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();

        int length = s.length();

        for (int i = 0; i < length; i++) {
            if (map.containsKey(charsS[i])) {
                if (!map.get(charsS[i]).equals(charsT[i])) {
                    return false;
                }
            } else {
                if (!map.containsValue(charsT[i])){
                    map.put(charsS[i], charsT[i]);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
