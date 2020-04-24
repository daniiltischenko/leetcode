package com.leetcode;

public class LC_387 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar_01("leetcode") == 0);
        System.out.println(firstUniqChar_01("loveleetcode") == 2);
        System.out.println(firstUniqChar_01("") == -1);
        System.out.println(firstUniqChar_01("aaaa") == -1);
    }

    static int firstUniqChar_01(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            count[aChar - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (count[chars[i] - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
