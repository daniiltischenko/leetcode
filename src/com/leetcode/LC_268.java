package com.leetcode;

import java.util.Arrays;

public class LC_268 {
    public static void main(String[] args) {
        System.out.println(missingNumber_01(new int[]{3,0,1}) == 2);
        System.out.println(missingNumber_01(new int[]{9,6,4,2,3,5,7,0,1}) == 8);

        System.out.println(missingNumber_02(new int[]{3,0,1}) == 2);
        System.out.println(missingNumber_02(new int[]{9,6,4,2,3,5,7,0,1}) == 8);

        System.out.println(missingNumber_03(new int[]{3,0,1}) == 2);
        System.out.println(missingNumber_03(new int[]{9,6,4,2,3,5,7,0,1}) == 8);
    }

    static int missingNumber_01(int[] nums) {
        int[] newNum = new int[nums.length+1];
        Arrays.fill(newNum, -1);

        for (int i = 0; i < nums.length; i++) {
            newNum[nums[i]] = nums[i];
        }

        for (int i = 0; i < newNum.length; i++) {
            if (newNum[i] == -1) {
                return i;
            }
        }

        return -1;
    }

    static int missingNumber_02(int[] nums) {
        int sum = 0;
        for (int i = 0; i <= nums.length; i++) {
            sum += i;
        }

        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    static int missingNumber_03(int[] nums) {
        int sum = nums.length * (nums.length + 1) / 2;

        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

}
