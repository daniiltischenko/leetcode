package com.leetcode;

public class LC_1290 {
    public static void main(String[] args) {
        System.out.println(getDecimalValue_01(new ListNode(1).setNext(new ListNode(0).setNext(new ListNode(1)))) == 5);
    }

    static int getDecimalValue_01(ListNode head) {
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val);
            head = head.next;
        }

        return Integer.parseInt(builder.toString(), 2);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this;
    }
}
