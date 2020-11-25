package com.java.ds.fastslowpointers;

public class ReArrangeLinkedList {
    /*
     nodes from the second half of the LinkedList are inserted alternately to the nodes from the first half in reverse order.

     Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
     Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null  2nd half is alternating and reverse

     1. We can use the Fast & Slow pointers method similar to Middle of the LinkedList to find the middle node of the LinkedList.
     2. Once we have the middle of the LinkedList, we will reverse the second half of the LinkedList.
     3. Finally, we’ll iterate through the first half and the reversed second half to produce a LinkedList in the required order.
     */

    public static void reorder(ListNode head) {
        if (head == null || head.next == null)
            return;

        // find the middle of the LinkedList
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is now pointing to the middle node
        ListNode headSecondHalf = reverse(slow); // reverse the second half
        ListNode headFirstHalf = head;

        // rearrange to produce the LinkedList in the required order
        while (headFirstHalf != null && headSecondHalf != null) {
            ListNode temp = headFirstHalf.next;
            headFirstHalf.next = headSecondHalf;
            headFirstHalf = temp;

            temp = headSecondHalf.next;
            headSecondHalf.next = headFirstHalf;
            headSecondHalf = temp;
        }

        // set the next of the last node to 'null'
        if (headFirstHalf != null)
            headFirstHalf.next = null;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
