package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC_242 {
    public static void main(String[] args) {
        System.out.println(isAnagram_01("anagram", "nagaram") == true);
        System.out.println(isAnagram_01("rat", "car") == false);
        System.out.println();
        System.out.println(isAnagram_02("anagram", "nagaram") == true);
        System.out.println(isAnagram_02("rat", "car") == false);
        System.out.println();
        System.out.println(isAnagram_03("anagram", "nagaram") == true);
        System.out.println(isAnagram_03("rat", "car") == false);
        System.out.println();
        System.out.println(isAnagram_04("anagram", "nagaram") == true);
        System.out.println(isAnagram_04("rat", "car") == false);
        System.out.println();
        System.out.println(isAnagram_05("anagram", "nagaram") == true);
        System.out.println(isAnagram_05("rat", "car") == false);
        System.out.println();
        System.out.println(isAnagram_06("anagram", "nagaram") == true);
        System.out.println(isAnagram_06("rat", "car") == false);
    }

    static boolean isAnagram_01(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char c : s.toCharArray()) {
            Integer num = map1.getOrDefault(c, 0);
            map1.put(c, ++num);
        }

        for (char c : t.toCharArray()) {
            Integer num = map2.getOrDefault(c, 0);
            map2.put(c, ++num);
        }

        return map1.equals(map2);
    }

    static boolean isAnagram_02(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            Integer num = map.getOrDefault(c, 0);
            map.put(c, ++num);
        }

        for (char c : t.toCharArray()) {
            Integer num = map.getOrDefault(c, 0);
            if (num == 0) {
                return false;
            } else if (num == 1) {
                map.remove(c);
            } else {
                map.put(c, --num);
            }
        }

        return map.isEmpty();
    }

    static boolean isAnagram_03(String s, String t) {
        int[] first = new int[123];
        int[] second = new int[123];

        for (char c : s.toCharArray()) {
            first[c]++;
        }

        for (char c : t.toCharArray()) {
            second[c]++;
        }

        return Arrays.equals(first, second);
    }

    static boolean isAnagram_04(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        if (s.equals(t)) {
            return true;
        }

        int[] first = new int[123];
        int[] second = new int[123];

        for (int i = 0; i < s.length(); i++) {
            first[s.charAt(i)]++;
            second[t.charAt(i)]++;
        }

        return Arrays.equals(first, second);
    }

    static boolean isAnagram_05(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        if (s.equals(t)) {
            return true;
        }

        int[] occurrences = new int[26];

        for (char c : s.toCharArray()) {
            occurrences[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            occurrences[c - 'a']--;
        }

        for (int occurrence : occurrences) {
            if (occurrence != 0) {
                return false;
            }
        }

        return true;
    }

    static boolean isAnagram_06(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }
}
