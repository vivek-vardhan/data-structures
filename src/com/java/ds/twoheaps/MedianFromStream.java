package com.java.ds.twoheaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFromStream {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());; //containing first half of numbers
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();; //containing second half of numbers

    /* either both the heaps will have equal number of elements or max-heap will have one  more element than the min-heap

    1. If max Heap is empty or element smaller to top of max heap - insert at max heap else min heap

    2. max heap size cannot be more than 1 of min heap MAX(maxHeapsize - minHeapSize) == 1

    3.minSize can never be greater than max heap


    */
    public void insertNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) { //if max heap is empty
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }


        // either both the heaps will have equal number of elements or max-heap will have one more element than the min-heap
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // we have even number of elements, take the average of middle two elements
            return (maxHeap.peek()+ minHeap.peek() )/ 2.0;
        }
        // else max-heap will have one more element than the min-heap, so top of max heap is the median
        return maxHeap.peek();
    }


}
