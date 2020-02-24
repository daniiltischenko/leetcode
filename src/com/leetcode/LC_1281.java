package com.leetcode;

public class LC_1281 {
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234) == 15);
        System.out.println(subtractProductAndSum(4421) == 21);
    }

    static int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        do {
            int remainder = n % 10;
            product *= remainder;
            sum += remainder;
            n  /= 10;
        } while (n!=0);
        return product - sum;
    }
}
