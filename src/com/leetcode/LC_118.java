package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_118 {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i) {
                    cur.add(1);
                }
                else {
                    int a = result.get(i - 1).get(j - 1);
                    int b = result.get(i - 1).get(j);
                    cur.add(a + b);
                }
            }
            result.add(cur);
        }

        return result;
    }
}
