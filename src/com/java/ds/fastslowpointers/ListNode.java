package com.java.ds.fastslowpointers;

public class ListNode {

    public int value = 0;
    public ListNode next;

    public ListNode()
    {

    }


    public ListNode(int value)
    {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}
