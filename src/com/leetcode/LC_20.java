package com.leetcode;

import java.util.*;

public class LC_20 {

    public static void main(String[] args) {
        System.out.println(isValid_01("()") == true);
        System.out.println(isValid_01("()[]{}") == true);
        System.out.println(isValid_01("(]") == false);
        System.out.println(isValid_01("([)]") == false);
        System.out.println(isValid_01("{[]}") == true);
        System.out.println(isValid_01("]") == false);

        System.out.println(isValid_02("()") == true);
        System.out.println(isValid_02("()[]{}") == true);
        System.out.println(isValid_02("(]") == false);
        System.out.println(isValid_02("([)]") == false);
        System.out.println(isValid_02("{[]}") == true);
        System.out.println(isValid_02("]") == false);
    }

    static boolean isValid_01(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(map.get(c));
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    static boolean isValid_02(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (isOpen(c)) {
                stack.push(reverse(c));
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isOpen(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }

    private static char reverse(char ch) {
        if (ch == '(') {
            return ')';
        } else if (ch == '{') {
            return '}';
        } else if (ch == '[') {
            return ']';
        }

        return ch;
    }
}
