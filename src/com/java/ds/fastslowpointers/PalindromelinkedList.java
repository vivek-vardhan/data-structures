package com.java.ds.fastslowpointers;


public class PalindromelinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        //Find middle of linkedList
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //slow is at middle, reverese from here
        ListNode reversed = reverse(slow);

        //Compare now
        while (reversed != null) {
            if (reversed.value != head.value ) {
                return false;
            }
            reversed = reversed.next;
            head = head.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next = head;
        ListNode current = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current =next;
        }

        return prev;
    }
}
