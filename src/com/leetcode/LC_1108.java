package com.leetcode;

public class LC_1108 {
    public static void main(String[] args) {
        System.out.println(defangIPaddr_01("1.1.1.1").equals("1[.]1[.]1[.]1"));
        System.out.println(defangIPaddr_01("255.100.50.0").equals("255[.]100[.]50[.]0"));

        System.out.println(defangIPaddr_02("1.1.1.1").equals("1[.]1[.]1[.]1"));
        System.out.println(defangIPaddr_02("255.100.50.0").equals("255[.]100[.]50[.]0"));

        System.out.println(defangIPaddr_03("1.1.1.1").equals("1[.]1[.]1[.]1"));
        System.out.println(defangIPaddr_03("255.100.50.0").equals("255[.]100[.]50[.]0"));
        System.out.println(defangIPaddr_03("1.1.1.1"));
        System.out.println(defangIPaddr_03("255.100.50.0"));
    }

    static String defangIPaddr_01(String address) {
        return address.replace(".", "[.]");
    }

    static String defangIPaddr_02(String address) {
        StringBuilder builder = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c =='.') {
                builder.append("[.]");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    static String defangIPaddr_03(String address) {
        char[] result = new char[address.length() + 6];
        char[] addressChars = address.toCharArray();
        int count = 0;
        for (int i = 0; i < addressChars.length; i++) {
            if (addressChars[i] == '.') {
                result[i + count] = '[';
                result[i+1 + count] = '.';
                result[i+2 + count] = ']';
                count = count + 2;
            } else {
                result[i + count] = addressChars[i];
            }
        }
        return new String(result);
    }
}
