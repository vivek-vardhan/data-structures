package com.java.ds.listreversal;

import com.java.ds.fastslowpointers.ListNode;

public class RotateLinkedList {

    /*

    Input : 1->2->3->4-5>6->null, K = 3
    Output: 4->5->6->1->2->3->null

     */

    public static ListNode rotate(ListNode head, int rotations) {
        if (head == null || head.next == null || rotations <= 0) {
            return head;
        }
        // find the length and the last node of the list
        ListNode lastNode = head;
        int listLength = 1;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            listLength++;
        }

        lastNode.next = head; // connect the last node with the head to make it a circular list

        rotations %= listLength; // no need to do rotations more than the length of the list
        int skipLength = listLength - rotations;

        ListNode lastNodeOfRotatedList = head;
        for (int i = 0; i < skipLength - 1; i++) {
            lastNodeOfRotatedList = lastNodeOfRotatedList.next;
        }

        // 'lastNodeOfRotatedList.next' is pointing to the sub-list of 'k' ending nodes
        head = lastNodeOfRotatedList.next;
        lastNodeOfRotatedList.next = null;

        return head;
    }
}
