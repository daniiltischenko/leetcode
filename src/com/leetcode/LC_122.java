package com.leetcode;

public class LC_122 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}) == 7);
        System.out.println(maxProfit(new int[]{1,2,3,4,5}) == 4);
        System.out.println(maxProfit(new int[]{7,6,4,3,1}) == 0);
        System.out.println(maxProfit(new int[]{1,5,6,10}) == 9);
    }

    static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}