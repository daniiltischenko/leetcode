package com.leetcode;

import java.util.*;

public class LC_49 {
    public static void main(String[] args) {
        System.out.println(groupAnagrams_01(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams_02(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams_03(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams_04(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    //1524 ms
    static List<List<String>> groupAnagrams_01(String[] strs) {
        Map<int[], List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] array = new int[26];
            for (char c : str.toCharArray()) {
                array[c - 'a']++;
            }
            int[] key = array;
            for (int[] ints : map.keySet()) {
                if (Arrays.equals(array, ints)) {
                    key = ints;
                }
            }
            List<String> strings = map.getOrDefault(key, new ArrayList<>());
            strings.add(str);
            map.putIfAbsent(key, strings);
        }

        return new ArrayList<>(map.values());
    }

    // Runtime: 6 ms, faster than 97.12% of Java online submissions for Group Anagrams.
    static List<List<String>> groupAnagrams_02(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> strings = map.getOrDefault(key, new ArrayList<>());
            strings.add(str);
            map.putIfAbsent(key, strings);
        }
        return new ArrayList<>(map.values());
    }

    // Runtime: 18 ms, faster than 40.14% of Java online submissions for Group Anagrams.
    static List<List<String>> groupAnagrams_03(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] array = new int[26];
            for (char c : str.toCharArray()) {
                array[c - 'a']++;
            }
            String key = Arrays.toString(array);
            List<String> strings = map.getOrDefault(key, new ArrayList<>());
            strings.add(str);
            map.putIfAbsent(key, strings);
        }

        return new ArrayList<>(map.values());
    }

    static List<List<String>> groupAnagrams_04(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] array = new int[26];
            for (char c : str.toCharArray()) {
                array[c - 'a']++;
            }
            Integer key = Arrays.hashCode(array);
            List<String> strings = map.getOrDefault(key, new ArrayList<>());
            strings.add(str);
            map.putIfAbsent(key, strings);
        }

        return new ArrayList<>(map.values());
    }
}
