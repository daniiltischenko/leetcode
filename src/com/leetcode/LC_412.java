package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_412 {
    public static void main(String[] args) {
        System.out.println(fizzBuzz_01(15).equals(Arrays.asList( "1",
                "2",
                "Fizz",
                "4",
                "Buzz",
                "Fizz",
                "7",
                "8",
                "Fizz",
                "Buzz",
                "11",
                "Fizz",
                "13",
                "14",
                "FizzBuzz")));
    }

    static List<String> fizzBuzz_01(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }
}
