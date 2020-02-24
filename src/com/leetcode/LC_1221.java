package com.leetcode;

public class LC_1221 {
    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL") == 4);
        System.out.println(balancedStringSplit("RLLLLRRRLR") == 3);
        System.out.println(balancedStringSplit("LLLLRRRR") == 1);
        System.out.println(balancedStringSplit("RLRRRLLRLL") == 2);
    }

    static int balancedStringSplit(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int balancedCount = 0;
        int rightCount = 0;
        int leftCount = 0;

        for (char cur : s.toCharArray()) {
            if ('L' == cur) {
                leftCount++;
            } else if ('R' == cur) {
                rightCount++;
            }

            if (rightCount == leftCount) {
                balancedCount++;
                leftCount = rightCount = 0;
            }
        }
        return balancedCount;
    }
}
