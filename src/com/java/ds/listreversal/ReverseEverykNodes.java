package com.java.ds.listreversal;

import com.java.ds.fastslowpointers.ListNode;


public class ReverseEverykNodes {

    /**
     *
     * 1 2 3   4 5 6   7 8 9  10 11, k = 3
     *
     * Output: 3 2 1   6 5 4   9 8 7   10 11
     *
     */

    int total = 0;
    boolean conversionNeeded = false;
    public ListNode reverseEveryKNode(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }
        int count  = countReversals( head, k); //count when to break
        ListNode nodeWhichNotBeReversed = findNodeNotReversed(head,  k);
        ListNode current = head, prev = null;
        ListNode lastNodeOfPrevSubList = null;
        while (count-- > 0) {
            lastNodeOfPrevSubList = prev;
            ListNode lastNodeOfCurrentSubList = current; //this will be revesed eventually
            ListNode next = null;
            for (int i=0; current != null && i < k;i++) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            //Connect now
            if (lastNodeOfPrevSubList != null) {
                lastNodeOfPrevSubList.next = prev; //start of this reversal, usually we return prev as head
            } else {
                head = prev;
            }
            //prepare for next iteration
            prev = lastNodeOfCurrentSubList; //maintain lastNdde of current as prev for next iteration

        }
        if (prev!= null) {
            prev.next = nodeWhichNotBeReversed;
        }


        return head;

    }

    private ListNode findNodeNotReversed(ListNode head, int k) {
        if (!conversionNeeded) {
            return null;
        }
        ListNode current = head;
        ListNode firstNodeOfNext = current;
        while (current != null) {
            firstNodeOfNext = current;
            for (int i =0;current != null && i<k;i++) {
                current = current.next;
            }
        }
        return firstNodeOfNext;

    }

    private int countReversals(ListNode head, int k) {
        ListNode current = head;
        while (current !=  null) {
            total++;
            current = current.next;
        }
        conversionNeeded = total%k !=0;
        return total/k;
    }


}
