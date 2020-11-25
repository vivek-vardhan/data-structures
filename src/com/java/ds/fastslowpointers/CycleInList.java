package com.java.ds.fastslowpointers;

public class CycleInList {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;

    }

    public int lengthOfCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int cycleLength = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycleLength = calculateLength(slow);
            }
        }
        ListNode startofCycle = findStart(head, cycleLength);
        System.out.println(startofCycle.value);

        return cycleLength;
    }

    private int calculateLength(ListNode slow) {
        ListNode next = slow.next;
        int cycleLength = 1;
        while (next != slow) {
            cycleLength++;
            next = next.next;
        }
        return cycleLength;
    }

    private  ListNode findStart(ListNode head, int cycleLength) {
        ListNode pointer1 = head, pointer2 = head;
        // move pointer2 ahead 'cycleLength' nodes
        while (cycleLength > 0) {
            pointer2 = pointer2.next;
            cycleLength--;
        }

        // increment both pointers until they meet at the start of the cycle
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1;
    }
}
