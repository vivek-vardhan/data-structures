package com.java.ds.fastslowpointers;

public class DoublyList {

    int value = 0;
    DoublyList next;
    DoublyList prev;

    public DoublyList()
    {

    }

    public DoublyList(int value, DoublyList next, DoublyList prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
