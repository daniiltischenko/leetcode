package com.leetcode;

public class LC_21 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    static ListNode mergeTwoLists_recursive(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            ListNode result = new ListNode(l2.val);
            mergeTwoLists_recursive(null, l2.next, result);
            return result;
        }

        if (l2 == null) {
            ListNode result = new ListNode(l1.val);
            return mergeTwoLists_recursive(l1.next, null, result);
        }

        if (l1.val < l2.val) {
            ListNode result = new ListNode(l1.val);
            mergeTwoLists_recursive(l1.next, l2, result);
            return result;
        } else {
            ListNode result = new ListNode(l2.val);
            mergeTwoLists_recursive(l1, l2.next, result);
            return result;
        }
    }

    private static ListNode mergeTwoLists_recursive(ListNode l1, ListNode l2, ListNode result) {
        if (l1 == null && l2 == null) {
            return result;
        }

        if (l1 == null) {
            result.next = new ListNode(l2.val);
            return mergeTwoLists_recursive(null, l2.next, result.next);
        }

        if (l2 == null) {
            result.next = new ListNode(l1.val);
            return mergeTwoLists_recursive(l1.next, null, result.next);
        }

        if (l1.val < l2.val) {
            result.next = new ListNode(l1.val);
            return mergeTwoLists_recursive(l1.next, l2, result.next);
        } else {
            result.next = new ListNode(l2.val);
            return mergeTwoLists_recursive(l1, l2.next, result.next);
        }
    }

    static ListNode mergeTwoLists_iterative(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode handler = head;
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                handler.next = l1;
                l1 = l1.next;
            } else {
                handler.next = l2;
                l2 = l2.next;
            }
            handler = handler.next;
        }

        if (l1 != null) {
            handler.next = l1;
        } else if (l2 != null) {
            handler.next = l2;
        }

        return head.next;
    }
}
