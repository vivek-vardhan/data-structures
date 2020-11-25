package com.java.ds.listreversal;

import com.java.ds.fastslowpointers.ListNode;

public class ReverseLinkedList {


    //The best question
    public ListNode revereseBetweenNodes(ListNode head, int m, int n) {


/**
 * Input: 1 2 3    4 5 6 7 8 9     10 11  ->    1 2 3   9 8 7 6 5 4     10 11
 *
 * reverse 4 to 9, p = 4, q =9
 *
 */

        if (head == null) {
            return head;

        }
        ListNode prev = null;
        ListNode current = head;

        //reach to m
        while ( m-- >1) {
            prev = current;
            current = current.next;
            n--; //because n is also the number from 0
        }

        ListNode endOfFirstPart = prev; //this will be from which reverse starts
        ListNode startOfSecondPart = current; //this will be end where reverse will be connected

        while (n-->0) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        if (endOfFirstPart != null) {
            endOfFirstPart.next = prev; //some nodes were there before reversal, connect prev to that, in normal case, it will be null
        } else {
            head = prev; //means reverse started from beginning, so prev will become new head
        }
        startOfSecondPart.next = current; //connect later part which is not reversed

        return head;


    }


    public ListNode reverse(ListNode head) {
        ListNode current = head; // current node that we will be processing
        ListNode previous = null; // previous node that we have processed
        ListNode next = null; // will be used to temporarily store the next node

        while (current != null) {
            next = current.next; // temporarily store the next node
            current.next = previous; // reverse the current node
            previous = current; // before we move to the next node, point previous to the current node
            current = next; // move on the next node
        }
        // after the loop current will be pointing to 'null' and 'previous' will be the new head
        return previous;
    }
}
